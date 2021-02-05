package crawlerdatawebsite;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.nodes.Document;

import model.*;

/**
 *
 * @author admin
 */
public abstract class Crawler {
	public Document doc;
	protected String url;
	public List<DayTrading> listTrading = new ArrayList<>();

	public Crawler() {
		this("https://s.cafef.vn/Lich-su-giao-dich-VNINDEX-1.chn");
	}

	public Crawler(String url) {
		setUrl(url);
	}

	public Document getDoc() {
		return doc;
	}

	public void setDoc(Document doc) {
		this.doc = doc;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<DayTrading> getListTrading() {
		return listTrading;
	}

	public void setListTrading(List<DayTrading> listTrading) {
		this.listTrading = listTrading;
	}

	public abstract void getDocumentFromURL() throws IOException;
}
