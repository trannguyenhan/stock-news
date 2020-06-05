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
public class Nhom8_3 extends NhomChung4{
    
    public Nhom8_3(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i, imax = 0;
        double max = 0;
        try {
            max = Double.parseDouble(this.rfStockCode.list[0].getKl_Auction());
        } catch (Exception e) {
        }
        
        for (i = 1; i < this.rfStockCode.totalRow; i++) {
            Double klAuction = 0.0;
            try {
                klAuction = Double.parseDouble(this.rfStockCode.list[i].getKl_Auction());
            } catch (Exception e) {
            }
            if (klAuction > max) {
                imax = i;
                max = klAuction;
            }
        }
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + "hôm nay, trong các mã Upcom, mã ");
        printWriter.print(this.rfStockCode.list[imax].getStockCode() + " có khối lượng giao dịch cao nhất với " + max + " nghìn cổ phiếu");
        
//        printWriter.println();
    }
}
