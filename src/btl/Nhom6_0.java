/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.PrintWriter;
import hotro.*;

/**
 *
 * @author Admin
 */
public class Nhom6_0 extends NhomChung3{
    
    public Nhom6_0(ReadFile rfVNINDEX, ReadFile fUPCOMINDEX, ReadFile rfHNXINDEX) {
        super(rfVNINDEX, rfHNXINDEX, rfHNXINDEX);
    }
    
    @Override
    public void printResult(PrintWriter printWriter) {
        int i;
        RandomClass rand = new RandomClass();
        for (i = 0; i < this.rfVNINDEX.totalRow; i++) {         
            printWriter.print(rand.getRandomString1());
            printWriter.print(" " + this.rfVNINDEX.list[i].getDate() + ", VN-Index ");
            printWriter.print(" chốt tại mốc " + this.rfVNINDEX.list[i].getFinalPrice() + " điểm");
            
            
            int month = Integer.parseInt(this.rfVNINDEX.list[i].getDate().substring(3, 5));
            int j = i + 1;
            if (j != this.rfVNINDEX.totalRow)
            do {
                int monthj = Integer.parseInt(this.rfVNINDEX.list[j].getDate().substring(3, 5));
                if (monthj != month)
                    break;
                j++;
            } while (j < this.rfVNINDEX.totalRow);
            if (j < this.rfVNINDEX.totalRow) {
                printWriter.print(" (tháng " + this.rfVNINDEX.list[j].getDate().charAt(4) + ": VN-Index là " + this.rfVNINDEX.list[j].getFinalPrice() + " điểm)");
            }
            
            
            printWriter.print("; còn HNX-Index chốt tại mốc " + this.rfHNXINDEX.list[i].getFinalPrice() + " điểm");
            if (j < this.rfVNINDEX.totalRow) {
                printWriter.print(" (tháng " + this.rfHNXINDEX.list[j].getDate().charAt(4) + ": HNX-Index là " + this.rfHNXINDEX.list[j].getFinalPrice() + " điểm)");
            }
            printWriter.println();
        }
    }
}
