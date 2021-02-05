package crawlerdatawebsite;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import model.*;

/**
 *
 * @author admin
 */
public class CrawlerVNINDEX extends Crawler {

	public CrawlerVNINDEX(String url) {
		super(url);
	}

	@Override
	public void getDocumentFromURL() throws IOException {
		doc = Jsoup.connect(url).get();
		Element eleTable = doc.getElementById("GirdTable2");
		int i = 2;

		try {
			while (eleTable.getElementsByTag("tr").get(i) != null) {
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

				DayTrading tempchiso = new DayTrading(strDate, strFinalPrice, strChange, strKLAuction, strGTAuction,
						strKLDeal, strGTDeal, strOpenPrice, strMaxPrice, strMinPrice);
				listTrading.add(tempchiso);
				i++;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
