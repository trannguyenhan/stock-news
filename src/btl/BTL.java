/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BTL;

import java.io.IOException;
import java.io.PrintWriter;
/**
 *
 * @author admin
 */
public class BTL {
    public void BaiTapLon(String value0String, String value1String, String value2String) throws IOException {
        ReadFile rfVNINDEX = new ReadFile();
        ReadFile rfUPCOMINDEX = new ReadFile();
        ReadFile rfHNXINDEX = new ReadFile();

//        rfVNINDEX.readFileExcel("C:/Users/admin/Downloads/VN-INDEX-FILE.xlsx");
//        rfUPCOMINDEX.readFileExcel("C:/Users/admin/Downloads/UPCOM-INDEX(1).xlsx");
//        rfHNXINDEX.readFileExcel("C:/Users/admin/Downloads/HNX-INDEX(1).xlsx");
        rfVNINDEX.readFileExcel(value0String);
        rfUPCOMINDEX.readFileExcel(value1String);
        rfHNXINDEX.readFileExcel(value2String);

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

//        // Nhom 5-2
//        for(int i=0; i<rfUPCOMINDEX.totalRow; i++)
//        {
//            Nhom5_2 nhom5_2 = new Nhom5_2(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
//            nhom5_2.printResult(printWriter);
//        }
//
//        // Nhom 5-3
//        for(int i=0; i<rfHNXINDEX.totalRow; i++)
//        {
//            Nhom5_3 nhom5_3 = new Nhom5_3(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
//            nhom5_3.printResult(printWriter);
//        }
//
//        // Nhom 5-4
//        for(int i=0; i<rfHNXINDEX.totalRow; i++)
//        {
//            Nhom5_4 nhom5_4 = new Nhom5_4(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
//            nhom5_4.printResult(printWriter);
//        }

        // Dong file sau khi ket thuc in tat ca cac nhom
        printWriter.close();

    }

    public static void main(String[] args) throws IOException {

        Nhom6 nhom6 = new Nhom6();
        PrintWriter printWriter = new PrintWriter("ketqua.txt");
        nhom6.printResult(printWriter);
        printWriter.close();
    }
}
