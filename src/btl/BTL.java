/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author admin
 */
//String value0String, String value1String, String value2String
public class BTL {
    ReadFile rfVNINDEX = new ReadFile();
    ReadFile rfUPCOMINDEX = new ReadFile();
    ReadFile rfHNXINDEX = new ReadFile();
    ReadFile topInc = new ReadFile();
    ReadFile topDec = new ReadFile();
    ReadFile topKLGD = new ReadFile();
    ReadFileStockCode stock = new ReadFileStockCode();
    
    public BTL() throws IOException
    {
        topInc.readShortFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\top10.xlsx",0);
        topDec.readShortFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\top10.xlsx",1);
        topKLGD.readShortFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\top10.xlsx",2);
        stock.readColumnsExcel("E:\\[JAVA]NetBeans\\BTL\\test\\hose.xlsx");
        stock.readFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\hose.xlsx");
        
        rfVNINDEX.readFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\stock.xlsx",0);
        rfUPCOMINDEX.readFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\stock.xlsx",1);
        rfHNXINDEX.readFileExcel("E:\\[JAVA]NetBeans\\BTL\\test\\stock.xlsx",2);
    }
    
    public BTL(String valueString1, String valueString2, String valueString3) throws IOException
    {
        topInc.readShortFileExcel(valueString2,0);
        topDec.readShortFileExcel(valueString2,1);
        topKLGD.readShortFileExcel(valueString2,2);
        stock.readColumnsExcel(valueString3);
        
        rfVNINDEX.readFileExcel(valueString1,0);
        rfUPCOMINDEX.readFileExcel(valueString1,1);
        rfHNXINDEX.readFileExcel(valueString1,2);
    }
    
    public void writeFileTxt() throws IOException {    
        // File dau ra 
        PrintWriter printWriter = new PrintWriter("ketqua.txt");
        
        // Nhom 5-0
        for(int i=0; i<rfVNINDEX.totalRow; i++)
        {
            Nhom5_0 nhom5_0 = new Nhom5_0(rfVNINDEX.list[i],rfUPCOMINDEX.list[i],rfHNXINDEX.list[i]);
            nhom5_0.printResult(printWriter);
        }
        
        // Nhom 5-1
        for(int i=0; i<rfUPCOMINDEX.totalRow; i++)
        {
            Nhom5_1 nhom5_1 = new Nhom5_1(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_1.printResult(printWriter);
        }
        
        // Nhom 5-2
        for(int i=0; i<rfUPCOMINDEX.totalRow; i++)
        {
            Nhom5_2 nhom5_2 = new Nhom5_2(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_2.printResult(printWriter);
        }
        
        // Nhom 5-3
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_3 nhom5_3 = new Nhom5_3(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_3.printResult(printWriter);
        }
        
        // Nhom 5-4
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_4 nhom5_4 = new Nhom5_4(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_4.printResult(printWriter);
        }
        
        // Nhom 5-5
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_5 nhom5_5 = new Nhom5_5(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_5.printResult(printWriter);
        }
        
        // Nhom 5-6
        Nhom5_6 nhom5_6 = new Nhom5_6(rfVNINDEX.list, rfUPCOMINDEX.list, rfHNXINDEX.list, rfVNINDEX.totalRow);
        nhom5_6.printResult(printWriter);
        
        // Nhom 5-7
        Nhom5_7 nhom5_7 = new Nhom5_7(rfVNINDEX.list, rfUPCOMINDEX.list, rfHNXINDEX.list, rfVNINDEX.totalRow);
        nhom5_7.printResult(printWriter);
        
        // Nhom5-8
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_8 nhom5_8 = new Nhom5_8(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_8.printResult(printWriter);
        }
        
        // Nhom7-0
        Nhom7_0 nhom7_0 = new Nhom7_0(stock.list[0]);
        nhom7_0.printResult(printWriter);
        
        // Nhom7-1
        Nhom7_1 nhom7_1 = new Nhom7_1(topInc.list[0], topDec.list[0], topKLGD.list[0]);
        nhom7_1.printResult(printWriter);
        
        // Nhom 5-28
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_28 nhom5_28 = new Nhom5_28(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_28.printResult(printWriter);
        }
        
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Nhom5_29 nhom5_29 = new Nhom5_29(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_29.printResult(printWriter);
        }
        
        // Nhom 6-0
        Nhom6_0 nhom6_0 = new Nhom6_0(rfVNINDEX, rfUPCOMINDEX, rfHNXINDEX);
        nhom6_0.printResult(printWriter);
        printWriter.println();
        
        // Nhom 6-1
        Nhom6_1 nhom6_1 = new Nhom6_1(rfVNINDEX, rfUPCOMINDEX, rfHNXINDEX);
        nhom6_1.printResult(printWriter);
        printWriter.println();
        
        // Nhom 8-2
        Nhom8_2 nhom8_2 = new Nhom8_2(stock);
        nhom8_2.printResult(printWriter);
        printWriter.println();
        
        // Nhom 8-3
        Nhom8_3 nhom8_3 = new Nhom8_3(stock);
        nhom8_3.printResult(printWriter);
        printWriter.println();
        
        //Nhom 8-4
        Nhom8_4 nhom8_4 = new Nhom8_4(stock);
        nhom8_4.printResult(printWriter);
        printWriter.println();
        
        //Nhom 8-5
        Nhom8_5 nhom8_5 = new Nhom8_5(stock);
        nhom8_5.printResult(printWriter);
        printWriter.println();
        
        //Nhom 8-6
        Nhom8_6 nhom8_6 = new Nhom8_6(stock);
        nhom8_6.printResult(printWriter);
        printWriter.println();
        
        //Nhom 8-7
        Nhom8_7 nhom8_7 = new Nhom8_7(stock);
        nhom8_7.printResult(printWriter);
        printWriter.println();
        
        // Dong file sau khi ket thuc in tat ca cac nhom
        printWriter.close();
        
    }
    
    public List<String> layDuLieuNgayGanNhatVNINDEX()
    {
        List<String> str = new ArrayList<>();
        String temp;
        
        // Lay ngay
        temp = rfVNINDEX.list[0].getDate();
        str.add(temp);
        
        // Lay diem ket thuc
        temp = rfVNINDEX.list[0].getFinalPrice();
        str.add(temp);
        
        // Lay do thay doi 
        temp = rfVNINDEX.list[0].getChange();
        str.add(temp);
        
        //Lay gia tri Giao Dich
        temp = rfVNINDEX.list[0].getGT_deal();
        DoiCachDoc doi = new DoiCachDoc();
        temp = doi.doiCachDoc(temp);
        str.add(temp);
        
        return str;
    }
}
