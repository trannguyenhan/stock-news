/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.DSChiSo;
import hotro.RandomClass;
import java.io.PrintWriter;
import hotro.*;

/**
 *
 * @author Admin
 */
public class Nhom5_28 extends NhomChung1{
    
    public Nhom5_28(DSChiSo csVNINDEX, DSChiSo csUPCOMINDEX, DSChiSo csHNXINDEX) {
	super(csVNINDEX, csUPCOMINDEX, csHNXINDEX);
    }

    @Override
    public void printResult(PrintWriter printWriter) {
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1());
	printWriter.print("hôm nay, VN-Index chốt tại " + this.csVNINDEX.getFinalPrice() + " điểm (");
        printWriter.print((this.csVNINDEX.checkChange() ? "+" : "") + this.csVNINDEX.getChangePc() + "%)");
        
        
        printWriter.print(rand.getRandomString2() + " HNX-Index ");
	double changepc = Double.parseDouble(this.csHNXINDEX.getChangePc());
        printWriter.print((this.csHNXINDEX.checkChange() == true) ? "tăng " : "giảm ");
        if (Math.abs(changepc) <= 0.5) {
            printWriter.print("nhẹ ");
        }
        else if (Math.abs(changepc) >= 1.5) {
            printWriter.print("mạnh ");
        }
	printWriter.print("và dừng chân tại " + this.csHNXINDEX.getFinalPrice() + " điểm (");
        printWriter.print((changepc > 0) ? "+" : "");
        printWriter.print(changepc + "%).");
        
        printWriter.println();
	}
	
}
