/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class DSChiSo {
    private String date;
    private String finalPrice;
    private String change;
    private String KL_auction;
    private String GT_auction;
    private String KL_deal;
    private String GT_deal;
    private String openPrice;
    private String maxPrice;
    private String minPrice;
    private int inc;
    private int dec;
    private String stock;
    private String value;
    private List<String> stock_name = new ArrayList<>();
    private List<String> stock_price = new ArrayList<>();
    private List<String> stock_weight = new ArrayList<>();
    private List<String> company_name = new ArrayList<>();
    private List<String> change_percentage = new ArrayList<>();
    
    public DSChiSo()
    {
        this("00/00/00","0","0","0","0","0","0","0","0","0");
    }


    public DSChiSo(List<String> stock_name, List<String> company_name, List<String> stock_price,  List<String> change_percentage, List<String> stock_weight)

    {
        this.stock_name = stock_name;
        this.company_name = company_name;
        this.stock_price = stock_price;
        this.change_percentage =change_percentage;
        this.stock_weight = stock_weight;
    }

    public DSChiSo(int inc, int dec){//bao nhieu ma tang giam
        this.inc = inc;
        this.dec = dec;
//        this.stock  = stock;
//        this.value = value;
    }
    public DSChiSo(String date, String finalPrice, String change, String KL_auction, String GT_auction, String KL_deal, String GT_deal, String openPrice, String maxPrice, String minPrice) {
        this.date = date;
        this.finalPrice = finalPrice;
        this.change = change;
        this.KL_auction = KL_auction;
        this.GT_auction = GT_auction;
        this.KL_deal = KL_deal;
        this.GT_deal = GT_deal;
        this.openPrice = openPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
    }

    public List<String> getCompany_name() {
        return company_name;
    }

    public List<String> getChange_percentage() {
        return change_percentage;
    }

    public List<String> getStock_name() {
        return stock_name;
    }

    public List<String> getStock_price() {
        return stock_price;
    }

    public List<String> getStock_weight() {
        return stock_weight;
    }

    public int getInc() {
        return inc;
    }

    public int getDec() {
        return dec;
    }

    public String getDate()
    {
        return date;
    }
    
    public void setDate(String date)
    {
        this.date = date;
        return;
    }
    
    public String getFinalPrice()
    {
        return finalPrice;
    }
    
    public void setFinalPrice(String finalPrice)
    {
        this.finalPrice = finalPrice;
        return;
    }
    
    public String getChange()
    {
        // Hien tai change dang o dinh dang (vi du) 8.9 (1.14%) -> can thay doi thanh : 8.9 diem (1.14 %)
        int i;
        for(i=0; i<change.length(); i++)
            if(change.charAt(i) == '(') break;
        
        // Tach ra thanh 2 String 
        String temp1 = change.substring(0, i-1);
        String temp2 = change.substring(i,change.length());
        
        // Gop lai temp1 + " diem " + temp2
        String temp = temp1 + " điểm " + temp2;
        
        return temp;
    }
    
    public void setChange(String change)
    {
        this.change = change;
        return;
    }
    
    public String getKL_auction()
    {
        return KL_auction;
    }
    
    public void setKL_auction(String KL_auction)
    {
        this.KL_auction = KL_auction;
        return;
    }
    
    public String getGT_auction()
    {
        return GT_auction;
    }
    
    public void setGT_auction(String GT_auction)
    {
        this.GT_auction = GT_auction;
        return;
    }
    
    public String getKL_deal()
    {
        return KL_deal;
    }
    
    public void setKL_deal(String KL_deal)
    {
        this.KL_deal = KL_deal;
        return;
    }
    
    public String getGT_deal()
    {
        return GT_deal;
    }
    
    public void setGT_deal(String GT_deal)
    {
        this.GT_deal = GT_deal;
        return;
    }
    
    public String getOpenPrice()
    {
        return openPrice;
    }
    
    public void setOpenPrice(String openPrice)
    {
        this.openPrice = openPrice;
        return;
    }
    
    public String getMaxPrice()
    {
        return maxPrice;
    }
    
    public void setMaxPrice(String maxPrice)
    {
        this.maxPrice = maxPrice;
        return;
    }
    
    public String getMinPrice()
    {
        return minPrice;
    }
    
    public void setMinPrice(String minPrice)
    {
        this.minPrice = minPrice;
        return;
    }
}
