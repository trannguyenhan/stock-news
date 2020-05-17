/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class Nhom5_5 extends NhomChung1{

    public Nhom5_5(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3) {
        super(chiso1, chiso2, chiso3);
    }
    
    public void printResult(PrintWriter printWriter)
    {
        DoiCachDoc doi = new DoiCachDoc();
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + " " + csVNINDEX.getDate() + " ");
        if (csVNINDEX.getChange().charAt(0) == '-')
            printWriter.print("VN-INDEX giảm " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice());
        else printWriter.print("VN-INDEX tăng " + csVNINDEX.getChange() + " lên tới " + csVNINDEX.getFinalPrice());
        
        printWriter.print(", KLGD thỏa thuận đạt " + doi.doiCachDoc(csVNINDEX.getKL_deal()) + " cổ phiếu, tương đương " + doi.doiCachDoc(csVNINDEX.getGT_deal()) + " đồng.");
        printWriter.print(" Trong khi, HNX-INDEX và UPCOM-INDEX giao dịch lần lượt là " + doi.doiCachDoc(csHNXINDEX.getKL_deal()) + ", " 
            + doi.doiCachDoc(csUPCOMINDEX.getKL_deal()) + " cổ phiếu, với giá trị tương ứng là " + doi.doiCachDoc(csHNXINDEX.getGT_deal()) + ", "
            + doi.doiCachDoc(csUPCOMINDEX.getKL_deal() + " đồng."));
        printWriter.println();
        //printWriter.println(doiCachDoc(csVNINDEX.getKL_deal()));
    }
    
    
}
