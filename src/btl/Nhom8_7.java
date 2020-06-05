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
public class Nhom8_7 extends NhomChung4{

    public Nhom8_7(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i, magiam = 0;
        for (i = 1; i < this.rfStockCode.totalRow; i++) {
            Double changenb = 0.0;
            try {
                changenb = Double.parseDouble(this.rfStockCode.list[i].getChangeNb());
            } catch (Exception e) {
            }
            
            if (changenb < 0) {
                magiam++;
            }
        }
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + "hôm nay, có tổng cộng " + magiam + " mã Upcom bị giảm điểm.");
        
//        printWriter.println();
        
    }
}
