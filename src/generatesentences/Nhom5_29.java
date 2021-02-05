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
public class Nhom5_29 extends NhomChung1{
    
    public Nhom5_29(DayTrading csVNINDEX, DayTrading csUPCOMINDEX, DayTrading csHNXINDEX) {
	super(csVNINDEX, csUPCOMINDEX, csHNXINDEX);
    }
  
  
    public void printResult(PrintWriter printWriter) {
        RandomClass rand = new RandomClass();
        
        printWriter.print(rand.getRandomString1());
	printWriter.print("hôm qua, VN-Index đã ");
        printWriter.print((this.csVNINDEX.checkChange() ? "tăng " : "giảm ") + this.csVNINDEX.getChangeNb() + " điểm (");
        printWriter.print((this.csVNINDEX.checkChange() ? "+" : "") + this.csVNINDEX.getChangePc() + "%) ");
        printWriter.print(this.csVNINDEX.checkChange() ? "lên " : "còn ");
	printWriter.print(this.csVNINDEX.getFinalPrice() + " điểm ");
        
        printWriter.print(rand.getRandomString2() + " chỉ số HNX-Index ");
	printWriter.print((this.csHNXINDEX.checkChange() ? "tăng " : "giảm ") + this.csHNXINDEX.getChangeNb() + " điểm (");
        printWriter.print((this.csHNXINDEX.checkChange() ? "+ " : "") + this.csHNXINDEX.getChangePc() + "%) ");
        printWriter.print((this.csHNXINDEX.checkChange() ? "lên " : "còn ") + this.csHNXINDEX.getFinalPrice() + " điểm.");
        
        printWriter.println();
    }
}
