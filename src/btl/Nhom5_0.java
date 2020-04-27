/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_0 {
    DSChiSo csVNINDEX;
    DSChiSo csUPCOMINDEX;
    DSChiSo csHNXINDEX;
    
    public Nhom5_0(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        this.csVNINDEX = chiso1;
        this.csUPCOMINDEX = chiso2;
        this.csHNXINDEX = chiso3;
    }
    
    public void printResult(PrintWriter printWriter) throws FileNotFoundException
    {
        
        printWriter.print("Hết ngày " + csVNINDEX.getDate() + ", VN-INDEX ");
        
        if(csVNINDEX.getChange().charAt(0) != '-') 
            printWriter.print("tăng " + csVNINDEX.getChange() + " lên " + csVNINDEX.getFinalPrice() + " điểm.");
        else
            printWriter.print("giảm " + csVNINDEX.getChange() + " xuống " + csVNINDEX.getFinalPrice() + " điểm; ");
        
        printWriter.print(" Trong khi UPCOM-INDEX");
        
        if(csUPCOMINDEX.getChange().charAt(0) == '-') 
        {
            printWriter.print(" giảm " + csUPCOMINDEX.getChange() + " còn " + csUPCOMINDEX.getFinalPrice() + " điểm, ");
            
            if(csHNXINDEX.getChange().charAt(0)  == '-')
                printWriter.print("HNX-INDEX giảm " + csHNXINDEX.getChange() + " còn " + csHNXINDEX.getFinalPrice() + " điểm.");
            else
                printWriter.print(" HNX-INDEX tăng.");
        }
        else 
        {
            printWriter.print(" tăng và ");
            
            if(csHNXINDEX.getChange().charAt(0)  == '-')
                printWriter.print("HNX-INDEX giảm " + csHNXINDEX.getChange() + " còn " + csHNXINDEX.getFinalPrice() + " điểm.");
            else
                printWriter.print(" HNX-INDEX tăng.");
        }
        
        printWriter.println(); // Het cau, xuong dong.
        
        return;
    }
}
