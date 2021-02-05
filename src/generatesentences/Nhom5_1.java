/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.PrintWriter;

import model.*;

/**
 *
 * @author admin
 */
public class Nhom5_1 extends NhomChung1{
    
    public Nhom5_1(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3)
    {
        super(chiso1, chiso2, chiso3);
    }
    
    public void printResult(PrintWriter printWriter)
    {
        printWriter.print("Theo đó, VN-INDEX đóng cửa ");
        if(csVNINDEX.getChange().charAt(0) != '-')
        {
            if(csVNINDEX.getChange().charAt(0) == '0')
                printWriter.print("tăng nhẹ " + csVNINDEX.getChange() + " lên " + csVNINDEX.getFinalPrice() + " điểm, ");
            else 
                printWriter.print("tăng " + csVNINDEX.getChange() + " lên " + csVNINDEX.getFinalPrice() + " điểm, ");
        } else
        {
            printWriter.print("tại mốc tham chiếu " + csVNINDEX.getFinalPrice() + " giảm " + csVNINDEX.getChange() + ", ");
        }
        
        if(csHNXINDEX.getChange().charAt(0) == '-' && csUPCOMINDEX.getChange().charAt(0) == '-')
            printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều giảm điểm.");
        else if(csHNXINDEX.getChange().charAt(0) != '-' && csUPCOMINDEX.getChange().charAt(0) != '-')
            printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều đóng cửa trong xắc xanh. ");
        else if(csHNXINDEX.getChange().charAt(0) != '-')
            printWriter.print("Trong khi HNX-INDEX đóng cửa với xắc xanh thì UPCOM-INDEX lại đóng cửa giảm điểm. ");
        else printWriter.print("Trong khi HNX-INDEX đóng cửa giảm điểm thì UPCOM-INDEX lại đóng cửa với xắc xanh. ");
        
        printWriter.println();
        return;
    }
}
