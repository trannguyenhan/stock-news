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
public class Nhom6_1 extends NhomChung3{
    
    public Nhom6_1(ReadFile rfVNINDEX, ReadFile rfUPCOMINDEX, ReadFile rfHNXINDEX) {
        super(rfVNINDEX, rfUPCOMINDEX, rfHNXINDEX);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i;
        RandomClass rand = new RandomClass();
        
        for (i = 0; i < this.rfVNINDEX.totalRow; i++) {
            printWriter.print(rand.getRandomString1());
            printWriter.print(this.rfVNINDEX.list[i].getDate() + ", ");
            
            
            int j = i + 1;
            int count = 0; //count: dem so ngay lien tuc tang hoac giam
            
            if (j < this.rfVNINDEX.totalRow) {
                count = 1;
                boolean lientuc = true;
                while (j + 1 < this.rfVNINDEX.totalRow && lientuc == true) {
                    if (this.rfVNINDEX.list[j].checkChange() == this.rfVNINDEX.list[j + 1].checkChange()) {
                        count++;
                    }
                    else {
                        lientuc = false;
                    }
                    j++;
                }
            }
            
            if (count > 1) {
                printWriter.print("sau " + count + " ngày ");
                printWriter.print((this.rfVNINDEX.list[i + 1].checkChange() ? "tăng " : "giảm ") + "liên tục, ");
            }
            printWriter.print("chỉ số VN-Index ");
            if (count > 1) {
                printWriter.print((this.rfVNINDEX.list[i].checkChange() == this.rfVNINDEX.list[i + 1].checkChange()) ? "tiếp tục " : "đã bất ngờ ");
            }
            printWriter.print((this.rfVNINDEX.list[i].checkChange() ? "tăng " : "giảm ") + this.rfVNINDEX.list[i].getChangeNb() + " điểm (");
            printWriter.print((this.rfVNINDEX.list[i].checkChange() ? "+" : "") + this.rfVNINDEX.list[i].getChangePc() + "%)");
            
            
            
            printWriter.print("; còn chỉ số HNX-Index thì ");
            count = 0; j = i + 1;
            if (j < this.rfHNXINDEX.totalRow) {
                count = 1;
                boolean lientuc = true;
                while (j + 1 < this.rfHNXINDEX.totalRow && lientuc == true) {
                    if (this.rfHNXINDEX.list[j].checkChange() == this.rfHNXINDEX.list[j + 1].checkChange()) {
                        count++;
                    }
                    else {
                        lientuc = false;
                    }
                    j++;
                }
            }
            if (count > 1) {
                printWriter.print((this.rfHNXINDEX.list[i].checkChange() == this.rfHNXINDEX.list[i + 1].checkChange()) ? "tiếp tục " : "đã bất ngờ ");
            }
            printWriter.print((this.rfHNXINDEX.list[i].checkChange() ? "tăng " : "giảm ") + this.rfHNXINDEX.list[i].getChangeNb() + " điểm (");
            printWriter.print((this.rfHNXINDEX.list[i].checkChange() ? "+" : "") + this.rfHNXINDEX.list[i].getChangePc() + "%)");
            if (count > 1) {
                printWriter.print(" sau " + count + " ngày ");
                printWriter.print((this.rfVNINDEX.list[i + 1].checkChange() ? "tăng " : "giảm ") + "liên tục, ");
            }
            printWriter.print(".");
            
            
            printWriter.println();
        }
        
    }
}

