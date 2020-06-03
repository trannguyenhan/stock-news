/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotro;

import java.io.IOException;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadFileStockCode {
    private final int MAX_ROW = 1000;
	private XSSFWorkbook wb;
  
	public DSChiSoStockCode[] list;
  
	public int totalRow;
        
        public ReadFileStockCode() {
            this.list = new DSChiSoStockCode[1000];
            this.totalRow = 0;
	}
        
        public String getCellValue(XSSFCell cell) {
            double doubleTemp;
            String stringTemp;
            switch (cell.getCellType()) {
		case STRING:
                    stringTemp = cell.getStringCellValue();
                    return stringTemp;
		case NUMERIC:
                    doubleTemp = cell.getNumericCellValue();
                    stringTemp = String.valueOf(doubleTemp);
		break;
            } 
            stringTemp = "NULL";
            
            return stringTemp;
	}
        
        public void readFileExcel(String path) throws IOException {
            XSSFWorkbook wb = new XSSFWorkbook(path);
            XSSFSheet sh = wb.getSheetAt(0);
            XSSFRow row = sh.getRow(1);
            while (row != null) {
		XSSFCell cell = row.getCell(0);
		if (cell == null)
                    break; 
		String value0 = getCellValue(cell);
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
                cell = row.getCell(10);
		String value10 = getCellValue(cell);
		this.list[this.totalRow] = new DSChiSoStockCode(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9, value10);
		this.totalRow++;
		row = sh.getRow(this.totalRow + 1);
            } 
	}
        
        
    public void readColumnsExcel(String path) throws IOException{
        int increment_value = 0;
        int decrease_value = 0;
        int none_value = 0;
        int[] increment_list = {};
        XSSFWorkbook wb = new XSSFWorkbook(path);
        XSSFSheet sh = wb.getSheetAt(0); // Lay sheet dau tien

        XSSFRow row = sh.getRow(1);
        XSSFCell cell;
        while (row != null){
            cell = row.getCell(2);
            if(cell == null) break;
            String change_value = getCellValue(cell);
            if (change_value.startsWith("0.00")){
                none_value += 1;
            }else if (change_value.startsWith("-")){
                decrease_value += 1;
            }
            else{
                increment_value += 1;
            }
            totalRow++;
            row = sh.getRow(totalRow+1);
        }
        list[0] = new DSChiSoStockCode(increment_value ,decrease_value);
    }
}
