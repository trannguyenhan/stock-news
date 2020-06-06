/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileinput;

import java.io.IOException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import crawlerdatawebsite.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author admin
 */
public class ExportStockDaTaToFileExcel {
    CrawlerDaTaHOSE crawHOSE = new CrawlerDaTaHOSE("https://s.cafef.vn/TraCuuLichSu2/1/HOSE/03/06/2020.chn");
    XSSFWorkbook wb = new XSSFWorkbook();
    
    public void exportDaTaHOSE() throws IOException
    {
        crawHOSE.getDocumentFromURL();
        
        XSSFSheet sheet = wb.createSheet("UPCOM-INDEX");
        
        int rownum = 0;
        int maxrownum = crawHOSE.dSChiSoStockCode.size();
        
        XSSFRow row;
        XSSFCell cell;
        
        // Dong tieu de 
        row = sheet.createRow(rownum);
        cell = row.createCell(0,CellType.STRING);
        cell.setCellValue("Mã");
        
        cell = row.createCell(1,CellType.STRING);
        cell.setCellValue("Giá đóng cửa");
        
        cell = row.createCell(2,CellType.STRING);
        cell.setCellValue("Thay đổi (+/-%)");
        
        cell = row.createCell(3,CellType.STRING);
        cell.setCellValue("Giá tham chiếu");
        
        cell = row.createCell(4,CellType.STRING);
        cell.setCellValue("Giá mở cửa");
        
        cell = row.createCell(5,CellType.STRING);
        cell.setCellValue("Giá cao nhất");
        
        cell = row.createCell(6,CellType.STRING);
        cell.setCellValue("Giá thấp nhất");
        
        cell = row.createCell(7,CellType.STRING);
        cell.setCellValue("GTGD Khớp lệnh");
        
        cell = row.createCell(8,CellType.STRING);
        cell.setCellValue("KLGD Khớp lệnh");
        
        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("KLGD Thỏa thuận");
        
        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("GTGD Thỏa thuận");
        rownum++;
        
        // Nhap du lieu 
        while(rownum <= maxrownum)
        {
            row = sheet.createRow(rownum);
            cell = row.createCell(0,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getStockCode());

            cell = row.createCell(1,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getFinalPrice());

            cell = row.createCell(2,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getChange());

            cell = row.createCell(3,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getReferencePrice());

            cell = row.createCell(4,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getOpenPrice());

            cell = row.createCell(5,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getMaxPrice());

            cell = row.createCell(6,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getMinPrice());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getGt_Auction());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getKl_Auction());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getKl_Deal());
            
            cell = row.createCell(10,CellType.STRING);
            cell.setCellValue(crawHOSE.dSChiSoStockCode.get(rownum-1).getGt_Deal());
            rownum++;
        }
    }
    
    public void export(String pathString) throws FileNotFoundException, IOException
    {
        File file;
        if(pathString == null)
        {
            file = new File("E:\\[JAVA]NetBeans\\BTL\\test\\stock.xlsx");
        } else 
            file = new File(pathString+"\\hose.xlsx");
        
        FileOutputStream fileoutput = new FileOutputStream(file);
        wb.write(fileoutput);
    }
}
