/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotro;

/**
 *
 * @author Admin
 */
public class DSChiSoStockCode {
    private String stockCode;
    private String finalPrice;
    private String change;
    private String referencePrice;
    private String openPrice;
    private String maxPrice;
    private String minPrice; 
    private String gt_Auction;
    private String kl_Auction;
    private String kl_Deal;
    private String gt_Deal;
    private int inc;
    private int dec;
    
    public DSChiSoStockCode() {
        this("0", "0", "0", "0", "0", "0", "0", "0", "0", "0", "0");
    }
    
    public DSChiSoStockCode(int inc, int dec){//bao nhieu ma tang giam
        this.inc = inc;
        this.dec = dec;
    }
    
    public DSChiSoStockCode(String stockCode, String finalPrice, String change, String referencePrice, String openPrice, String maxPrice, String minPrice, String gt_Auction, String kl_Auction, String kl_Deal, String gt_Deal) {
        this.stockCode = stockCode;
        this.finalPrice = finalPrice;
        this.change = change;
        this.referencePrice = referencePrice;
        this.openPrice = openPrice;
        this.maxPrice = maxPrice;
        this.minPrice = minPrice;
        this.gt_Auction = gt_Auction;
        this.kl_Auction = kl_Auction;
        this.kl_Deal = kl_Deal;
        this.gt_Deal = gt_Deal;
    }
 
    public int getInc() {
        return inc;
    }

    public int getDec() {
        return dec;
    }
    
    public String getStockCode() {
        return stockCode;
    }

    public void setStockCode(String stockCode) {
        this.stockCode = stockCode;
    }

    public String getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangeNb()
    {
        int i;
        if(change == null) return change; // Xư li exception
        for(i=0; i<change.length(); i++)
            if(change.charAt(i) == '(') break;
        
        return (change.substring(0, i-1));
    }
    
    public String getChangePc()
    {
        int i;
        for(i=0; i<change.length(); i++)
            if(change.charAt(i) == '(') break;
        
        return (change.substring(i + 1,change.length() - 2));
    }
    
    
    public String getReferencePrice() {
        return referencePrice;
    }

    public void setReferencePrice(String referencePrice) {
        this.referencePrice = referencePrice;
    }

    public String getOpenPrice() {
        return openPrice;
    }

    public void setOpenPrice(String openPrice) {
        this.openPrice = openPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getGt_Auction() {
        int i;
        for (i = 0; i < gt_Auction.length(); i++) {
            if (gt_Auction.charAt(i) == ',') {
                gt_Auction = gt_Auction.substring(0, i - 1) + gt_Auction.substring(i + 1, gt_Auction.length());
            }
        }
        return gt_Auction;
    }

    public void setGt_Auction(String gt_Auction) {
        this.gt_Auction = gt_Auction;
    }

    public String getKl_Auction() {
        return kl_Auction;
    }

    public void setKl_Auction(String kl_Auction) {
        this.kl_Auction = kl_Auction;
    }

    public String getKl_Deal() {
        return kl_Deal;
    }

    public void setKl_Deal(String kl_Deal) {
        this.kl_Deal = kl_Deal;
    }

    public String getGt_Deal() {
        return gt_Deal;
    }

    public void setGt_Deal(String gt_Deal) {
        this.gt_Deal = gt_Deal;
    }
 
}
