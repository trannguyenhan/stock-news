package crawlerdatawebsite;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 * Export data to file excel, path : result/stock.xlsx 
 */ 
public class ExportData {
    private CrawlerVNINDEX crawVNINDEX;
    private CrawlerUPCOMINDEX crawUPCOMINDEX;
    private CrawlerHNXINDEX crawHNXINDEX;
    
    private XSSFWorkbook wb = new XSSFWorkbook();
    
    public CrawlerVNINDEX getCrawVNINDEX() {
		return crawVNINDEX;
	}

	public void setCrawVNINDEX(CrawlerVNINDEX crawVNINDEX) {
		this.crawVNINDEX = crawVNINDEX;
	}

	public CrawlerUPCOMINDEX getCrawUPCOMINDEX() {
		return crawUPCOMINDEX;
	}

	public void setCrawUPCOMINDEX(CrawlerUPCOMINDEX crawUPCOMINDEX) {
		this.crawUPCOMINDEX = crawUPCOMINDEX;
	}

	public CrawlerHNXINDEX getCrawHNXINDEX() {
		return crawHNXINDEX;
	}

	public void setCrawHNXINDEX(CrawlerHNXINDEX crawHNXINDEX) {
		this.crawHNXINDEX = crawHNXINDEX;
	}

	public XSSFWorkbook getWb() {
		return wb;
	}

	public void setWb(XSSFWorkbook wb) {
		this.wb = wb;
	}

	public ExportData()
    {
        crawVNINDEX = new CrawlerVNINDEX("https://s.cafef.vn/Lich-su-giao-dich-VNINDEX-1.chn");
        crawUPCOMINDEX = new CrawlerUPCOMINDEX("https://s.cafef.vn/Lich-su-giao-dich-UPCOM-INDEX-1.chn");
        crawHNXINDEX = new CrawlerHNXINDEX("https://s.cafef.vn/Lich-su-giao-dich-HNX-INDEX-1.chn");
    }
    
    private void exportDataVNINDEX() throws IOException
    {
        crawVNINDEX.getDocumentFromURL();
        XSSFSheet sheet = wb.createSheet("VN-INDEX");
        
        int rownum = 0;
        int maxrownum = crawVNINDEX.listTrading.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // title line
        row = sheet.createRow(rownum);
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue("Date");
        
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue("FinalPrice");
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Change");
        
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue("KL_auction");
        
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue("GT_auction");
        
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue("KL_Deal");
        
        cell = row.createCell(6,CellType.STRING);
        cell.setCellValue("GT_Deal");
        
        cell = row.createCell(7,CellType.STRING);
        cell.setCellValue("OpenPrice");
        
        cell = row.createCell(8,CellType.STRING);
        cell.setCellValue("MaxPrice");
        
        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("MinPrice");
        rownum++;
        
        // insert data
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawVNINDEX.listTrading.get(rownum-1).getMinPrice());
            rownum++;
        }
    }
     
    private void exportDaTaUPCOMINDEX() throws IOException
    {
        crawUPCOMINDEX.getDocumentFromURL();
        XSSFSheet sheet = wb.createSheet("UPCOM-INDEX");
        
        int rownum = 0;
        int maxrownum = crawUPCOMINDEX.listTrading.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // title line
        row = sheet.createRow(rownum);
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue("Date");
        
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue("FinalPrice");
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Change");
        
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue("KL_auction");
        
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue("GT_auction");
        
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue("KL_Deal");
        
        cell = row.createCell(6,CellType.STRING);
        cell.setCellValue("GT_Deal");
        
        cell = row.createCell(7,CellType.STRING);
        cell.setCellValue("OpenPrice");
        
        cell = row.createCell(8,CellType.STRING);
        cell.setCellValue("MaxPrice");
        
        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("MinPrice");
        rownum++;
        
        // insert data
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.listTrading.get(rownum-1).getMinPrice());
            rownum++;
        }
        
    }
    
    private void exportDaTaHNXINDEX() throws IOException
    {
        crawHNXINDEX.getDocumentFromURL();
        XSSFSheet sheet = wb.createSheet("HNX-INDEX");
        
        int rownum = 0;
        int maxrownum = crawHNXINDEX.listTrading.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // title line
        row = sheet.createRow(rownum);
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue("Date");
        
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue("FinalPrice");
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Change");
        
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue("KL_auction");
        
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue("GT_auction");
        
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue("KL_Deal");
        
        cell = row.createCell(6,CellType.STRING);
        cell.setCellValue("GT_Deal");
        
        cell = row.createCell(7,CellType.STRING);
        cell.setCellValue("OpenPrice");
        
        cell = row.createCell(8,CellType.STRING);
        cell.setCellValue("MaxPrice");
        
        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("MinPrice");
        rownum++;
        
        // insert data
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.listTrading.get(rownum-1).getMinPrice());
            rownum++;
        }
        
    }
    
    public void export() throws FileNotFoundException, IOException
    {
        File file = new File("result/stock.xlsx");;
        
        this.exportDataVNINDEX();
        this.exportDaTaUPCOMINDEX();
        this.exportDaTaHNXINDEX();
        
        FileOutputStream fileoutput = new FileOutputStream(file);
        wb.write(fileoutput);
    }
}
