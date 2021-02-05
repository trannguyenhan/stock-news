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
public class Nhom5_4 extends NhomChung1{
    
    public Nhom5_4(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3)
    {
        super(chiso1,chiso2,chiso3);
    }
    
    public void printResult(PrintWriter printWriter) throws FileNotFoundException
    {
        RandomClass rand = new RandomClass();
        
        printWriter.print(rand.getRandomString1() + " " + csVNINDEX.getDate() + ", chỉ số VN-INDEX ");
        if(csVNINDEX.getChange().charAt(0) == '-')
            printWriter.print("giảm " + csVNINDEX.getChange() + " về mốc " + csVNINDEX.getFinalPrice() + " điểm, ");
        else printWriter.print("tăng" + csVNINDEX.getChange() + " lên tới mốc " + csVNINDEX.getFinalPrice() + " điểm, ");
        
        printWriter.print(rand.getRandomString2() + " " + csHNXINDEX.getDate() + ", chỉ số HNX-INDEX ");
        if(csHNXINDEX.getChange().charAt(0) == '-')
            printWriter.print("giảm " + csHNXINDEX.getChange() + " về mốc " + csHNXINDEX.getFinalPrice() + " điểm và ");
        else printWriter.print("tăng" + csHNXINDEX.getChange() + " lên tới mốc " + csVNINDEX.getFinalPrice() + " điểm và ");
        
        printWriter.print(rand.getRandomString2() + " " + csUPCOMINDEX.getDate() + ", chỉ số VN-INDEX ");
        if(csUPCOMINDEX.getChange().charAt(0) == '-')
            printWriter.print("giảm " + csUPCOMINDEX.getChange() + " về mốc " + csUPCOMINDEX.getFinalPrice() + " điểm, ");
        else printWriter.print("tăng" + csUPCOMINDEX.getChange() + " lên tới mốc " + csUPCOMINDEX.getFinalPrice() + " điểm, ");
        
        printWriter.println();
        return;
    }
    
}
