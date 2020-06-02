/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinput;

import crawlerdatawebsite.CrawlerDaTaHNXINDEX;
import crawlerdatawebsite.CrawlerDaTaUPCOMINDEX;
import crawlerdatawebsite.CrawlerDaTaVNINDEX;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import static javax.management.openmbean.SimpleType.STRING;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ExportDaTaToFileExcel {
    CrawlerDaTaVNINDEX crawVNINDEX;
    CrawlerDaTaUPCOMINDEX crawUPCOMINDEX;
    CrawlerDaTaHNXINDEX crawHNXINDEX;
    
    XSSFWorkbook wb = new XSSFWorkbook();
    
    public ExportDaTaToFileExcel()
    {
        crawVNINDEX = new CrawlerDaTaVNINDEX("https://s.cafef.vn/Lich-su-giao-dich-VNINDEX-1.chn");
        crawUPCOMINDEX = new CrawlerDaTaUPCOMINDEX("https://s.cafef.vn/Lich-su-giao-dich-UPCOM-INDEX-1.chn");
        crawHNXINDEX = new CrawlerDaTaHNXINDEX("https://s.cafef.vn/Lich-su-giao-dich-HNX-INDEX-1.chn");
    }
    
    public void exportDaTaVNINDEX() throws IOException
    {
        crawVNINDEX.getDocumentFromURL();
        
        XSSFSheet sheet = wb.createSheet("VN-INDEX");
        
        int rownum = 0;
        int maxrownum = crawVNINDEX.dschiso.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // Dong tieu de 
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
        
        // Nhap du lieu 
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawVNINDEX.dschiso.get(rownum-1).getMinPrice());
            rownum++;
        }
        
//        File file = new File("E:\\[JAVA]NetBeans\\CrawlerDaTaWebsite\\excel.xlsx");
//        FileOutputStream fileoutput = new FileOutputStream(file);
//        wb.write(fileoutput);
    }
     
    public void exportDaTaUPCOMINDEX() throws IOException
    {
        crawUPCOMINDEX.getDocumentFromURL();
        
        XSSFSheet sheet = wb.createSheet("UPCOM-INDEX");
        
        int rownum = 0;
        int maxrownum = crawUPCOMINDEX.dschiso.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // Dong tieu de 
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
        
        // Nhap du lieu 
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawUPCOMINDEX.dschiso.get(rownum-1).getMinPrice());
            rownum++;
        }
        
    }
    
    public void exportDaTaHNXINDEX() throws IOException
    {
        crawHNXINDEX.getDocumentFromURL();
        
        XSSFSheet sheet = wb.createSheet("HNX-INDEX");
        
        int rownum = 0;
        int maxrownum = crawHNXINDEX.dschiso.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // Dong tieu de 
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
        
        // Nhap du lieu 
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getDate());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getKL_auction());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getGT_auction());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getKL_deal());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getGT_deal());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getOpenPrice());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getMaxPrice());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawHNXINDEX.dschiso.get(rownum-1).getMinPrice());
            rownum++;
        }
        
    }
    
    public void export() throws FileNotFoundException, IOException
    {
        File file = new File("E:\\[JAVA]NetBeans\\BTL\\test\\stock.xlsx");
        FileOutputStream fileoutput = new FileOutputStream(file);
        wb.write(fileoutput);
    }
}
