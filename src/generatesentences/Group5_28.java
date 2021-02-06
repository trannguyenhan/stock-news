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
 * @author Admin
 */
public class Group5_28 extends GeneralGroup1{
    
    public Group5_28(DayTrading csVNINDEX, DayTrading csUPCOMINDEX, DayTrading csHNXINDEX) {
	super(csVNINDEX, csUPCOMINDEX, csHNXINDEX);
    }

    @Override
    public void printResult(PrintWriter printWriter) {
        RandomSentence rand = new RandomSentence();
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
