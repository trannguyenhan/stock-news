/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
//String value0String, String value1String, String value2String
public class BTL {
    public void BaiTapLon(String valueString) throws IOException {
        ReadFile rfVNINDEX = new ReadFile();
        ReadFile rfUPCOMINDEX = new ReadFile();
        ReadFile rfHNXINDEX = new ReadFile();
        
        rfVNINDEX.readFileExcel(valueString,0);
        rfUPCOMINDEX.readFileExcel(valueString,1);
        rfHNXINDEX.readFileExcel(valueString,2);
//        rfVNINDEX.readFileExcel(value0String);
//        rfUPCOMINDEX.readFileExcel(value1String);
//        rfHNXINDEX.readFileExcel(value2String);
        
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
        
        // Dong file sau khi ket thuc in tat ca cac nhom
        printWriter.close();
        
    }
}
