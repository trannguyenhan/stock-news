/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.*;

/**
 *
 * @author admin
 */
public class Nhom5_5 extends NhomChung1{

    public Nhom5_5(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3) {
        super(chiso1, chiso2, chiso3);
    }
    
    public void printResult(PrintWriter printWriter)
    {
        Support doi = new Support();
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + " " + csVNINDEX.getDate() + " ");
        if (csVNINDEX.getChange().charAt(0) == '-')
            printWriter.print("VN-INDEX giảm " + csVNINDEX.getChange() + " xuống còn " + csVNINDEX.getFinalPrice());
        else printWriter.print("VN-INDEX tăng " + csVNINDEX.getChange() + " lên tới " + csVNINDEX.getFinalPrice());
        
        printWriter.print(", KLGD thỏa thuận đạt " + doi.convertReading(csVNINDEX.getKL_deal()) + " cổ phiếu, tương đương " + doi.convertReading(csVNINDEX.getGT_deal()) + " đồng.");
        printWriter.print(" Trong khi, HNX-INDEX và UPCOM-INDEX giao dịch lần lượt là " + doi.convertReading(csHNXINDEX.getKL_deal()) + ", " 
            + doi.convertReading(csUPCOMINDEX.getKL_deal()) + " cổ phiếu, với giá trị tương ứng là " + doi.convertReading(csHNXINDEX.getGT_deal()) + ", "
            + doi.convertReading(csUPCOMINDEX.getKL_deal() + " đồng."));
        printWriter.println();
        //printWriter.println(doiCachDoc(csVNINDEX.getKL_deal()));
    }
    
    
}
