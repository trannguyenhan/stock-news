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
public class Nhom8_4 extends NhomChung4{

    public Nhom8_4(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        int i, imax = 0;
        long max = 0;
        try {
            max = Long.parseLong(this.rfStockCode.list[0].getGt_Auction());
        } catch (Exception e) {
        }
        
        for (i = 1; i < this.rfStockCode.totalRow; i++) {
            long gtAuction = 0;
            try {
                gtAuction = Long.parseLong(this.rfStockCode.list[i].getGt_Auction());
            } catch (Exception e) {
            }
            
            if (gtAuction > max) {
                imax = i;
                max = gtAuction;
            }
        }
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + "hôm nay, trong các mã Upcom, mã ");
        printWriter.print(this.rfStockCode.list[imax].getStockCode() + " có giá trị giao dịch khớp lệnh cao nhất với " + max/1000000 + " triệu đồng.");
        
        printWriter.println();
        
    }
}
