/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author admin
 */
public class ReadFile {

    private final int MAX_ROW = 2000;
    private XSSFWorkbook wb;
    public DayTrading[] list;
    public int totalRow;
    
    public ReadFile()
    {
        list = new DayTrading[MAX_ROW];
        totalRow = 0;
    }
    
    private String getCellValue(XSSFCell cell)
    {
        String stringTemp;
        switch(cell.getCellType())
        {
            case STRING:
                stringTemp = cell.getStringCellValue();
                break;
            case NUMERIC: 
                double doubleTemp = cell.getNumericCellValue();
                stringTemp = String.valueOf(doubleTemp);
            default:
                stringTemp = "NULL";
        }
        
        return stringTemp;
    }
    
    public void read(String path, int sheetInput) throws IOException 
    {
        XSSFWorkbook wb = new XSSFWorkbook(path);
        XSSFSheet sh = wb.getSheetAt(sheetInput); // Lay sheet dau tien
        
        XSSFRow row = sh.getRow(1);
        XSSFCell cell;
        
        while(row != null)
        {
            cell = row.getCell(0);
            String value0;
            if(cell == null) break;
            try {
                value0 = new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
            } catch (Exception e) {
                //value0 = new SimpleDateFormat("dd/MM/yyyy").format(java.time.LocalDate.now());
                value0 = getCellValue(cell);
            }
            
            cell = row.getCell(1);
            String value1 = getCellValue(cell);
            
            cell = row.getCell(2);
            String value2 = getCellValue(cell);
            
            cell = row.getCell(3);
            String value3 = getCellValue(cell);
            
            cell = row.getCell(4);
            String value4 = getCellValue(cell);
            
            cell = row.getCell(5);
            String value5 = getCellValue(cell);
            
            cell = row.getCell(6);
            String value6 = getCellValue(cell);
            
            cell = row.getCell(7);
            String value7 = getCellValue(cell);
            
            cell = row.getCell(8);
            String value8 = getCellValue(cell);
            
            cell = row.getCell(9);
            String value9 = getCellValue(cell);
            
            list[totalRow] = new DayTrading(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9);
            totalRow++;
            
            row = sh.getRow(totalRow+1);
            
        }
    }   
}
