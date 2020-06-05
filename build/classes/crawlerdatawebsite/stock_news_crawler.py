# from selenium import webdriver
import time
# import urllib3
from urllib.request import urlopen
from bs4 import BeautifulSoup
import json
import datetime
import pprint
import sys
import os
import requests
import requests
from requests.adapters import HTTPAdapter
from requests.packages.urllib3.util.retry import Retry
#import pandas as pd

class Crawler():
    def __init__(self,url):
        self.url = url

    def get_links(self,pages,start_page_url):
        start_pages = 1
        links = []
        while (start_pages <= pages):
            link_found = []
            page_url = start_page_url.format(start_pages)

            session = requests.Session()
            retry = Retry(connect=3, backoff_factor=0.5)
            adapter = HTTPAdapter(max_retries=retry)
            session.mount('http://', adapter)
            session.mount('https://', adapter)
            source = session.get(page_url)
            soup  = BeautifulSoup(source.text,'html.parser')
            # print(soup)
            if self.url == 'https://cafef.vn':
                link_found = soup.find_all('a',class_='avatar show-popup visit-popup')
            elif self.url == 'https://vnexpress.net':
                h3_found = soup.find_all('h3',class_='title-news')
                # print(h3_found)
                for h3 in h3_found:
                    link_found.append(h3.find('a'))
            elif self.url == 'https://tinnhanhchungkhoan.vn':
                div_found = soup.find_all('div', class_='story__heading')
                for div in div_found:
                    link_found.append( div.find('a'))
            # print(link_found)
            for a in link_found:
                if a['href'].startswith('/'):
                    links.append(self.url + a['href'])
                else:
                    links.append(a['href'])
            # links.append([self.url+a['href'] for a in link_found])
            start_pages+=1
        # print(links)
        print('find {} article_links in {web}'.format(len(links),web = self.url))
        return links

    def extract_news(self, article_url):
        news_item={'url':'','title':'','time':'','description':'','content':''}
        source = requests.get(article_url)
        soup=BeautifulSoup(source.text,'html.parser')
        news_item['url']=article_url
        ##TNCK
        if article_url.startswith('https://tinnhanhchungkhoan.vn') :
            try:
                news_item['title']=soup.find('h1',attrs={'class':'article__header'}).text.replace('\n','')
                news_item['time']=soup.find('time').text
                news_item['description']=soup.find('div',attrs={'class':'article__sapo'}).text
            except:
                news_item['time']=''
                news_item['description']=''
                news_item['title']=''
            contents_html = soup.findAll('div',attrs={'class':"article__body"})
        #VNEX
        elif article_url.startswith('https://vnexpress.net'):
            try:
                news_item['title']=soup.find('h1',attrs={'class':'title-detail'}).text.replace('\n','')
                news_item['time']=soup.find('span',attrs={'class':'date'}).text
                news_item['description']=soup.find('p',attrs={'class':'description'}).text
            except:
                news_item['time']=''
                news_item['description']=''
                news_item['title']=''
            contents_html=soup.findAll('p',attrs={'class':'Normal'})
        #Cafef
        elif article_url.startswith('https://cafef.vn'):
            try:
                news_item['title']=soup.find('h1',attrs={'class':'title'}).text.replace('\n','')
                news_item['time']=soup.find('span',attrs={'class':'pdate'}).text
                news_item['description']=soup.find('h2',attrs={'class':'sapo'}).text
            except:
                news_item['time']=''
                news_item['description']=''
                news_item['title']=''
            contents_html=soup.find('span',attrs={'id':'mainContent'}).findAll('p')
            # print(contents_html.text)
        content_list=[]
        for content in contents_html:
            # print(content)
            content_list.append(content.text)
        # print(content_list)
        news_item['content']=' '.join(content_list)
        return news_item

def save_file(filename, url_list,crawler):
    dataset = []
    path = (os.getcwd()+'/{}').format(filename)
    for url in url_list:
        item = crawler.extract_news(url)
        dataset.append(item)
    with open(path,'w',encoding = 'utf-8') as json_file:
        json.dump(dataset,json_file,ensure_ascii = False,indent = 4)

def getDataFrame(url):
    df_list = pd.read_html(url,encoding='utf-8')
    return df_list

if __name__ == '__main__':
    cafef = Crawler('https://cafef.vn')
    cafef_url_list = cafef.get_links(1,'https://cafef.vn/timeline/31/trang-{}.chn')
    save_file('cafef.json', cafef_url_list, cafef)

    tnck = Crawler('https://tinnhanhchungkhoan.vn')
    tnck_url_list = tnck.get_links(1,'https://tinnhanhchungkhoan.vn/ajax/zone.aspx?zoneid=1&trang={}')
    save_file('tnck.json',tnck_url_list,tnck)

    vnex = Crawler('https://vnexpress.net')
    vnex_url_list = vnex.get_links(1,'https://vnexpress.net/kinh-doanh/p{}')
    save_file('vnex.json', vnex_url_list,vnex)
    # date = input("Enter date: ")
    # stock_platform = input("Enter stock platform: ")
    # url  = "https://s.cafef.vn/TraCuuLichSu2/3/{}/{}".format(stock_platform,date)
    # df = getDataFrame("https://s.cafef.vn/TraCuuLichSu2/3/HOSE/15/05/2020.chn")[1]
    # df.to_csv('file_name.csv',index = False)
    # df = pd.read_csv("/home/viethoang/petproject/OOP/STOCKNEWS_GENERATOR/crawler/file_name.csv",encoding='utf-8')
    # df = df.drop([0,1])
    # print(df)
