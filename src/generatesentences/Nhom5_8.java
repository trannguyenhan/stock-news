/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.*;

/**
 *
 * @author admin
 */
public class Nhom5_8 extends NhomChung1{
    
    public Nhom5_8(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3)
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
        
        Support doi = new Support();
        if(demtang >=2)
            printWriter.print("Thanh khoản thị trường duy trì khá tốt với giá trị khớp lệnh 3 sàn lần lượt là " 
                + doi.convertReading(csVNINDEX.getGT_auction()) + ", " + doi.convertReading(csUPCOMINDEX.getGT_auction()) + ", " 
                + doi.convertReading(csHNXINDEX.getGT_auction()) + ".");
        else 
            printWriter.print("Thanh khoản thị trường giảm nhẹ nhưng vẫn ở mức tương đối với giá trị khớp lệnh của VN-INDEX là "
                + doi.convertReading(csVNINDEX.getGT_auction()) + ".");
        printWriter.println();
    }
    
}
