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
import hotro.*;

/**
 *
 * @author admin
 */
public abstract class CrawlerDaTaWebsite {
    public Document doc;
    protected String url;
    public List<DSChiSo> dschiso = new ArrayList<>();
    
//    public CrawlerDaTaWebsite()
//    {
//        // Neu goi mac dinh -> goi toi san VN-INDEX
//        url = "https://s.cafef.vn/Lich-su-giao-dich-VNINDEX-1.chn";
//    }
//    
    public CrawlerDaTaWebsite(String url)
    {
        // Dung khi chuyen page tu 1 sang 2 thoi nha!
        this.url = url;
    }
    
    public abstract void getDocumentFromURL() throws IOException;
}
