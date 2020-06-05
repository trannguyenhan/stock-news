/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.RandomClass;
import hotro.ReadFileStockCode;
import java.io.PrintWriter;

/**
 *
 * @author Admin
 */
public class Nhom8_6 extends NhomChung4{

    public Nhom8_6(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i, imin = 0;
        double min = 0;
        try {
            min = Double.parseDouble(this.rfStockCode.list[0].getChangePc());
        } catch (Exception e) {
        }

        for (i = 1; i < this.rfStockCode.totalRow; i++) {
            Double changepc = 0.0;
            try {
                changepc = Double.parseDouble(this.rfStockCode.list[i].getChangePc());
            } catch (Exception e) {
            }
            if (changepc < min) {
                imin = i;
                min = changepc;
            }
        }
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + "hôm nay, trong các mã Upcom, mã ");
        printWriter.print(this.rfStockCode.list[imin].getStockCode() + " là mã giảm nhiều nhất khi giảm đến " + min + "% (");
        printWriter.print(this.rfStockCode.list[imin].getChangeNb() + " điểm).");
        
        printWriter.println();
        
    }
}
