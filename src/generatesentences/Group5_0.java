/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.*;

/**
 *
 * @author admin
 */
public class Group5_0 extends GeneralGroup1{
    
    public Group5_0(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3)
    {
        super(chiso1, chiso2, chiso3);
    }
    
    @Override
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
