/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.*;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_6 extends NhomChung2{
    
    public Nhom5_6(DSChiSo[] dsVNINDEX, DSChiSo[] dsUPCOMINDEX, DSChiSo[] dsHNXINDEX, int totalrow)
    {
        super(dsVNINDEX, dsUPCOMINDEX, dsHNXINDEX, totalrow);
    }
    
    /*Tra ve chi so cua ngay tang manh nhat*/
    private int tangManhNhat(DSChiSo[] dschiso)
    {
        int maxIndex = 0;
        double maxValue = 0;
        int i;
        for(i=0; i<totalrow; i++)
            if (dschiso[i].getChange().charAt(0) != '-')
            {
                // Tach lay gia tri dau cua truong Change, VD : 34.5 diem (1,3%) -> lay 34.5 diem
                int j;
                for(j=0; j<dschiso[i].getChange().length(); j++)
                    if(dschiso[i].getChange().charAt(j) == ' ') break;
                
                String tempString = dschiso[i].getChange().substring(0, j-1);
                double db = Double.valueOf(tempString);
                
                if(db > maxValue) 
                {
                    maxValue = db;
                    maxIndex = i;
                }
            }
        
        return maxIndex;
    }
            
    public void printResult(PrintWriter printWriter)
    {
        DoiCachDoc doi = new DoiCachDoc();
        
        printWriter.print("Từ ngày " + dsVNINDEX[totalrow-1].getDate() + " đến ngày " + dsVNINDEX[0].getDate() + ", ");
        
        int demNgayTang = 0;
        int ngayTangManhNhat = 0;
        for(int i=0; i<totalrow; i++)
            if(dsVNINDEX[i].getChange().charAt(0) != '-') 
                demNgayTang++;
        ngayTangManhNhat = tangManhNhat(dsVNINDEX);
        
        int demNgayGiam = totalrow - demNgayTang;
        
        printWriter.print("chỉ số VN-INDEX có " + demNgayTang + " ngày tăng. Trong đó tăng mạnh nhất là ngày " 
                + dsVNINDEX[ngayTangManhNhat].getDate() + " với " + dsVNINDEX[ngayTangManhNhat].getChange() + ", ");
        
        printWriter.print("KLGD trong ngày này đạt " + doi.doiCachDoc(dsVNINDEX[ngayTangManhNhat].getKL_deal()) + " cổ phiếu, tương đương "
        + doi.doiCachDoc(dsVNINDEX[ngayTangManhNhat].getGT_deal()) + " đồng.");
        
    }
    
}
