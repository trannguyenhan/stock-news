/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_2 {
    DSChiSo csVNINDEX;
    DSChiSo csUPCOMINDEX;
    DSChiSo csHNXINDEX;
    
    public Nhom5_2(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        this.csVNINDEX = chiso1;
        this.csUPCOMINDEX = chiso2;
        this.csHNXINDEX = chiso3;
    }
    
    public void printResult(PrintWriter printWriter)
    {
        if(csVNINDEX.getChange().charAt(0) == '-')
        {
            if(csHNXINDEX.getChange().charAt(0) != '-')
                printWriter.print("Trong khi VN-INDEX giảm " + csVNINDEX.getChange() + ", thì bên sàn Hà Nội HNX-INDEX bất ngờ tăng " + csHNXINDEX.getChange() + ". ");
            else
                printWriter.print("Tạm dừng phiên giao dịch chỉ số của VN-INDEX và HNX-INDEX đều giảm. ");
        } else 
        {
            printWriter.print("Kết thúc phiên giao dịch ngày " + csVNINDEX.getDate() + ", chỉ số của VN-INDEX tăng " + csVNINDEX.getChange() + ", ");
            if(csHNXINDEX.getChange().charAt(0) != '-' && csUPCOMINDEX.getChange().charAt(0) != '-')
                printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều chìm trong sắc xanh. ");
            else if(csHNXINDEX.getChange().charAt(0) == '-' && csUPCOMINDEX.getChange().charAt(0) == '-')
                printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều giảm điểm. ");
            else 
            {
                    printWriter.print("Trong khi HNX-INDEX đạt mốc tham chiếu tại " + csHNXINDEX.getFinalPrice() + " điểm và ");
                    printWriter.print("UPCOM-INDEX đạt mốc tham chiếu tại " + csUPCOMINDEX.getFinalPrice() + " điểm.");
            }
        }
        
        printWriter.println();
        return;
    }
}
