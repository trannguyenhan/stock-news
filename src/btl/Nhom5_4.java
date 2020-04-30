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
public class Nhom5_4 extends NhomChung{
    
    public Nhom5_4(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
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
        
        printWriter.print(rand.getRandomString2() + " ");
        if(csHNXINDEX.getChange().charAt(0) == '-')
            printWriter.print("HNX-INDEX giảm " + csHNXINDEX.getChange() + " xuống còn " + csHNXINDEX.getFinalPrice() + " điểm và ");
        else printWriter.print("HNX-INDEX tăng " + csHNXINDEX.getChange() + " lên mức " + csHNXINDEX.getFinalPrice() + " điểm và ");
        
        if(csUPCOMINDEX.getChange().charAt(0) == '-')
            printWriter.print("UPCOM-INDEX giảm " + csUPCOMINDEX.getChange() + " xuống còn " + csUPCOMINDEX.getFinalPrice() + " điểm. ");
        else printWriter.print("UPCOM-INDEX tăng " + csUPCOMINDEX.getChange() + " lên mức " + csUPCOMINDEX.getFinalPrice() + " điểm. ");
        
        printWriter.println();
        return;
    }
}
