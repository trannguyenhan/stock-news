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
 * @author admin
 */
public class Nhom5_7 extends NhomChung2{

    public Nhom5_7(DayTrading[] dsVNINDEX, DayTrading[] dsUPCOMINDEX, DayTrading[] dsHNXINDEX, int totalrow) {
        super(dsVNINDEX, dsUPCOMINDEX, dsHNXINDEX, totalrow);
    }

    /*kiem tra xem co bao nhieu ngay giam lien tiep truoc ngay X bat ki nao do*/
    public int soNgayGiam(DayTrading[] dSChiSo, int x)
    {
        int dem = 0;
        try {
            if(dSChiSo[x+1].getChange().charAt(0) == '-') dem++;
            else return 0; // Khong co ngay giam nao truoc ngay X
        
            for(int i=x+2; i<totalrow; i++)
                if(dSChiSo[i].getChange().charAt(0) == '-') dem++;
                else break;
        } catch (Exception e) {
        }
        
        return dem;
    }
    
    /*kiem tra xem co bao nhieu ngay tang lien tiep truoc ngay X bat ki nao do*/
    public int soNgayTang(DayTrading[] dSChiSo, int x)
    {
        int dem = 0;
        try {
            if(dSChiSo[x+1].getChange().charAt(0) != '-') dem++;
            else return 0; // Khong co ngay giam nao truoc ngay X
        
            for(int i=x+1; i<totalrow; i++)
                if(dSChiSo[i].getChange().charAt(0) != '-') dem++;
                else break;
        } catch (Exception e) {
        }
        return dem;
    }
    
    @Override
    public void printResult(PrintWriter printWriter) {
        int i = 0;
        
        while(i<totalrow)
        {
            if(dsVNINDEX[i].getChange().charAt(0) == '-')
            {
                    int ngaygiam = soNgayGiam(dsVNINDEX, i);
                    if(ngaygiam != 0)
                    {
                        if(ngaygiam == 1)
                            printWriter.print("Ngày " + dsVNINDEX[i].getDate() 
                                + ", chỉ số VN-INDEX tiếp tục giảm sau khi bắt đầu giảm 1 ngày trước đó.");
                        else 
                            printWriter.print("Ngày " + dsVNINDEX[i].getDate() 
                                + ", đã là phiên giảm điểm thứ " + ngaygiam+1 + " liên tiếp của VN-INDEX.");
                    } else 
                    {
                        int ngaytang = soNgayTang(dsVNINDEX, i);
                        if(ngaytang == 1)
                            printWriter.print("Chỉ số VN-INDEX đã giảm " + dsVNINDEX[i].getChange() + " sau 1 ngày tăng ( Ngày " 
                                + dsVNINDEX[i].getDate() + ")" );
                        else 
                            printWriter.print("Đây là phiên giảm điểm đầu tiên sau " + ngaytang + " ngày tăng liên tiếp ( Ngày " 
                                + dsVNINDEX[i].getDate() + ") của VN-INDEX.");
                    }   
            } else 
            {
                int ngaytang = soNgayTang(dsVNINDEX, i);
                if(ngaytang != 0)
                {
                    if(ngaytang == 1)
                        printWriter.print("Như vậy ngày " + dsVNINDEX[i].getDate() + ", là ngày thứ 2 liên tiếp điểm số của VN-INDEX tăng.");
                    else 
                        printWriter.print("Như vậy ngày " + dsVNINDEX[i].getDate() + ", đã là ngày tăng thứ " + ngaytang + " liên tiếp của VN-INDEX.");
                } else 
                {
                    int ngaygiam = soNgayGiam(dsVNINDEX, i);
                    if(ngaygiam == 1)
                        printWriter.print("Ngày " + dsVNINDEX[i].getDate() + ", chỉ số VN-INDEX đã có chút khởi sắc sau 1 ngày giảm. ");
                    else 
                        printWriter.print("Ngày " + dsVNINDEX[i].getDate() + ", chỉ số VN-INDEX đã tăng " + dsVNINDEX[i].getChange() 
                            + " sau " + ngaygiam + " ngày giảm liên tiếp.");
                    
                }
            }
            printWriter.println();
            i++;
        }
        
    }
    
}
