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
        printWriter.print("Tại thời điểm ngày " + csVNINDEX.getDate() + ", chỉ số VN-INDEX ");
        if(csVNINDEX.getChange().charAt(0) == '-')
            printWriter.print("giảm " + csVNINDEX.getChange() + " về mốc " + csVNINDEX.getFinalPrice() + " điểm, ");
        else printWriter.print("tăng" + csVNINDEX.getChange() + " lên tới mốc " + csVNINDEX.getFinalPrice() + " điểm, ");
    }
}
