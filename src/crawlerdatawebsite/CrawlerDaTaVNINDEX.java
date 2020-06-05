/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawlerdatawebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import hotro.*;

/**
 *
 * @author admin
 */
public class CrawlerDaTaVNINDEX extends CrawlerDaTaWebsite{
    
    public CrawlerDaTaVNINDEX(String url)
    {
        super(url);
    }
    
    @Override
    public void getDocumentFromURL() throws IOException
    {
        doc = Jsoup.connect(url).get();
        
        Element eleTable = doc.getElementById("GirdTable2");
        int i = 2;
        
        try {
            while(eleTable.getElementsByTag("tr").get(i) != null)
            {
                Element eleTR = eleTable.getElementsByTag("tr").get(i);

                String strDate = eleTR.getElementsByClass("Item_DateItem").text();
                String strFinalPrice = eleTR.getElementsByClass("Item_Price10").get(0).text();
                String strChange = eleTR.getElementsByClass("Item_ChangePrice").text();
                String strKLAuction = eleTR.getElementsByClass("Item_Price10").get(1).text();
                String strGTAuction = eleTR.getElementsByClass("Item_Price10").get(2).text();
                String strKLDeal = eleTR.getElementsByClass("Item_Price10").get(3).text();
                String strGTDeal = eleTR.getElementsByClass("LastItem_Price").text();
                String strOpenPrice = eleTR.getElementsByClass("Item_Price10").get(4).text();
                String strMaxPrice = eleTR.getElementsByClass("Item_Price10").get(5).text();
                String strMinPrice = eleTR.getElementsByClass("Item_Price10").get(6).text();

                DSChiSo tempchiso = new DSChiSo(strDate, strFinalPrice, strChange, strKLAuction, strGTAuction, strKLDeal, strGTDeal, strOpenPrice, strMaxPrice, strMinPrice);
                dschiso.add(tempchiso);
                i++;
                //System.out.println(strDate + " " + strFinalPrice + " " + strChange + " " + strKLAuction + " " + strGTAuction);
            }
        } catch (Exception e) {
            // Khi khong con du lieu de doc -> co 1 ngoai le xay ra, ket thuc va thoat khoi vong lap
        }
    }
}
