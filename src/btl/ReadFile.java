/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
public class ReadFile {

    private final int MAX_ROW = 1000;
    private XSSFWorkbook wb;
    public DSChiSo[] list;
    public int totalRow;
    
    public ReadFile()
    {
        list = new DSChiSo[MAX_ROW];
        totalRow = 0;
    }
    
    public String getCellValue(XSSFCell cell)
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
    
    public void readFileExcel(String path) throws IOException
    {
        XSSFWorkbook wb = new XSSFWorkbook(path);
        XSSFSheet sh = wb.getSheetAt(0); // Lay sheet dau tien

        XSSFRow row = sh.getRow(1);
        XSSFCell cell;

        while(row != null)
        {
            cell = row.getCell(0);
            if(cell == null) break;
            String value0 = new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());

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

            list[totalRow] = new DSChiSo(value0, value1, value2, value3, value4, value5, value6, value7, value8, value9);
            totalRow++;
            row = sh.getRow(totalRow+1);

        }
        System.out.println(totalRow);

        return;
    }
//phương thức mới
    
    public void readShortFileExcel(String path) throws IOException
    {
        XSSFWorkbook wb = new XSSFWorkbook(path);
        XSSFSheet sh = wb.getSheetAt(0); // Lay sheet dau tien

        XSSFRow row = sh.getRow(1);
        XSSFCell cell;
        List<String> list_name = new ArrayList<>();
        List<String> list_weight = new ArrayList<>();
        List<String> list_price = new ArrayList<>();
        List<String> list_company = new ArrayList<>();
        List<String> list_change = new ArrayList<>();

        while(row != null )
        {
            cell = row.getCell(0);
            if(cell == null) break;
            String value0 = getCellValue(cell);
            list_name.add(value0);

            cell = row.getCell(1);
            String value1 = getCellValue(cell);
            list_company.add(value1);

            cell = row.getCell(2);
            String value2 = getCellValue(cell);
            list_price.add(value2);
//            list[totalRow] = new DSChiSo(value0, value1, value2);
            cell =  row.getCell(4);
            String value4  = getCellValue(cell);
            list_change.add(value4);

            cell = row.getCell(5);
            String value5 =  getCellValue(cell);
            list_weight.add(value5);

            totalRow++;

            row = sh.getRow(totalRow+1);

        }
        list[0] = new DSChiSo(list_name,list_company,list_price,list_change,list_weight);

        System.out.println(totalRow);

        return;
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
            cell = row.getCell(1);
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
        list[0] = new DSChiSo(increment_value ,decrease_value);
    }
}
