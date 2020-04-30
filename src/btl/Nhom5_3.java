/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_3 extends NhomChung{
    
    
    public Nhom5_3(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        super(chiso1, chiso2, chiso3);
    }
    
    public void printResult(PrintWriter printWriter)
    {
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + " " + csVNINDEX.getDate() + ", " );
        if(csVNINDEX.getChange().charAt(0) == '-')
        {
            if(csVNINDEX.getChange().charAt(1) == '0') 
                printWriter.print("chỉ số của VN-INDEX giảm nhẹ " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice() + " điểm, ");
            else printWriter.print("chỉ số của VN-INDEX giảm " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice() + " điểm, ");
        } else 
        {
            if(csVNINDEX.getChange().charAt(0) == '0')
                printWriter.print("chỉ số của VN-INDEX tăng nhẹ " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice() + " điểm, ");
            else printWriter.print("chỉ số của VN-INDEX tăng " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice() + " điểm, ");
        }
        
        printWriter.print("trong khi ");
        if(csHNXINDEX.getChange().charAt(0) == '-' && csUPCOMINDEX.getChange().charAt(0) == '-')
        {
            if(csHNXINDEX.getChange().charAt(1) == '0' && csUPCOMINDEX.getChange().charAt(1) == '0')
                printWriter.print("HNX-INDEX và UPCOM-INDEX đã thu hẹp đà giảm. ");
            else 
                printWriter.print(" cả HNX-INDEX và UPCOM-INDEX đều giảm. ");
        }
        else 
        {
            if(csHNXINDEX.getChange().charAt(0) != '-' && csUPCOMINDEX.getChange().charAt(0) != '-')
            {
                if(csHNXINDEX.getChange().charAt(0) == '0' && csUPCOMINDEX.getChange().charAt(0) == '0')
                    printWriter.print("HNX-INDEX và UPCOM đều tăng nhẹ. ");
                else 
                    printWriter.print("cả HNX-INDEX và UPCOM-INDEX đều tăng. ");
            } else 
            {
                printWriter.print(" HNX-INDEX và UPCOM-INDEX đều biến động. ");
            }
        }
        
        printWriter.println();
        return;
    }
}
