/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.DSChiSo;
import hotro.DoiCachDoc;
import hotro.*;
import hotro.RandomClass;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_8 extends NhomChung1{
    
    public Nhom5_8(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        super(chiso1,chiso2,chiso3);
    }

    @Override
    public void printResult(PrintWriter printWriter) throws FileNotFoundException {
        
        RandomClass rand = new RandomClass();
        printWriter.print(rand.getRandomString1() + " " + csVNINDEX.getDate() + ", ");
        
        if(csVNINDEX.getChange().charAt(0) != 0)
            printWriter.print("chỉ số VN-INDEX tăng " + csVNINDEX.getChange() + ", ");
        else 
            printWriter.print("chỉ số VN-INDEX giảm " + csVNINDEX.getChange() + ", ");
        
        if(csUPCOMINDEX.getChange().charAt(0) != 0)
            printWriter.print("chỉ số UPCOM-INDEX tăng " + csUPCOMINDEX.getChange() + ", ");
        else 
            printWriter.print("chỉ số UPCOM-INDEX giảm " + csUPCOMINDEX.getChange() + ", ");
        
        if(csHNXINDEX.getChange().charAt(0) != 0)
            printWriter.print("chỉ số HNX-INDEX tăng " + csHNXINDEX.getChange() + ". ");
        else 
            printWriter.print("chỉ số HNX-INDEX giảm " + csHNXINDEX.getChange() + ". " );
        
        int demgiam = 0;
        int demtang = 0;
        
        if(csVNINDEX.getChange().charAt(0) == '-') demgiam++;
        else demtang++;
        
        if(csHNXINDEX.getChange().charAt(0) == '-') demgiam++;
        else demtang++;
        
        if(csUPCOMINDEX.getChange().charAt(0) == '-') demgiam++;
        else demtang++;
        
        DoiCachDoc doi = new DoiCachDoc();
        if(demtang >=2)
            printWriter.print("Thanh khoản thị trường duy trì khá tốt với giá trị khớp lệnh 3 sàn lần lượt là " 
                + doi.doiCachDoc(csVNINDEX.getGT_auction()) + ", " + doi.doiCachDoc(csUPCOMINDEX.getGT_auction()) + ", " 
                + doi.doiCachDoc(csHNXINDEX.getGT_auction()) + ".");
        else 
            printWriter.print("Thanh khoản thị trường giảm nhẹ nhưng vẫn ở mức tương đối với giá trị khớp lệnh của VN-INDEX là "
                + doi.doiCachDoc(csVNINDEX.getGT_auction()) + ".");
        printWriter.println();
    }
    
}
