package views;

import java.io.IOException;

import crawlerdatawebsite.ExportData;
import generatesentences.GenerateSentences;

public class MainController{
	public void bCraw() throws IOException{
		new ExportData().export();
	}
	
	public void bStock() throws IOException {
		new GenerateSentences().writeResult();
	}
}
