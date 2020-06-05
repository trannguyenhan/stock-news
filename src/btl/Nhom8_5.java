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
public class Nhom8_5 extends NhomChung4{
    
    public Nhom8_5(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i, imax = 0;
        double max = 0;
        try {
            max = Double.parseDouble(this.rfStockCode.list[0].getChangePc());
        } catch (Exception e) {
        }
        
        for (i = 1; i < this.rfStockCode.totalRow; i++) {
            Double changepc = 0.0;
            try {
                changepc = Double.parseDouble(this.rfStockCode.list[i].getChangePc());
            } catch (Exception e) {
            }
            
            if (changepc > max) {
                imax = i;
                max = changepc;
            }
        }
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + "hôm nay, trong các mã Upcom, mã ");
        printWriter.print(this.rfStockCode.list[imax].getStockCode() + " là mã tăng nhiều nhất khi tăng đến " + max + "% (");
        printWriter.print(this.rfStockCode.list[imax].getChangeNb() + " điểm).");
        
//        printWriter.println();
        
    }
}
