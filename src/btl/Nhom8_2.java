/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.ReadFileStockCode;
import java.io.PrintWriter; 


public class Nhom8_2 extends NhomChung4{

    public Nhom8_2(ReadFileStockCode rfStockCode) {
        super(rfStockCode);
    }
    
    public void printResult(PrintWriter printWriter) {
        printWriter.print("Trong ngày hôm nay, có tổng cộng ");
        long tonggt = 0;
        int i;
        double tongkl = 0;
        
        for (i = 0; i < this.rfStockCode.totalRow; i++) {
            long gtAuction = 0;
            double klAuction = 0;
            try {
                gtAuction = Integer.parseInt(this.rfStockCode.list[i].getGt_Auction());
                klAuction = Double.parseDouble(this.rfStockCode.list[i].getKl_Auction());
            } catch (Exception e) {
            }
            tonggt = tonggt + gtAuction;
            tongkl = tongkl + klAuction;
        }
        
        printWriter.print(Math.round(tongkl/1000) + " triệu cổ phiếu được chuyển nhượng với tổng giá trị giao dịch khoảng " + tonggt/1000000 + "triệu đồng.");
    }
}
