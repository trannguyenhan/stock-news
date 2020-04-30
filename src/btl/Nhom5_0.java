package BTL;


import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public class Nhom5_0 extends NhomChung{
    
    public Nhom5_0(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        super(chiso1, chiso2, chiso3);
    }
    
    public void printResult(PrintWriter printWriter) throws FileNotFoundException
    {
        
        printWriter.print("Hết ngày " + csVNINDEX.getDate() + ", VN-INDEX ");
        
        if(csVNINDEX.getChange().charAt(0) != '-') 
            printWriter.print("tăng " + csVNINDEX.getChange() + " lên " + csVNINDEX.getFinalPrice() + " điểm.");
        else
            printWriter.print("giảm " + csVNINDEX.getChange() + " xuống " + csVNINDEX.getFinalPrice() + " điểm; ");
        
        printWriter.print(" Trong khi UPCOM-INDEX");
        if (this.csUPCOMINDEX.getChange().charAt(0) == '-') {
            var10001 = this.csUPCOMINDEX.getChange();
            printWriter.print(" giảm " + var10001 + " còn " + this.csUPCOMINDEX.getFinalPrice() + " điểm, ");
            if (this.csHNXINDEX.getChange().charAt(0) == '-') {
                var10001 = this.csHNXINDEX.getChange();
                printWriter.print("HNX-INDEX giảm " + var10001 + " còn " + this.csHNXINDEX.getFinalPrice() + " điểm.");
            } else {
                printWriter.print(" HNX-INDEX tăng.");
            }
        } else {
            printWriter.print(" tăng và ");
            if (this.csHNXINDEX.getChange().charAt(0) == '-') {
                var10001 = this.csHNXINDEX.getChange();
                printWriter.print("HNX-INDEX giảm " + var10001 + " còn " + this.csHNXINDEX.getFinalPrice() + " điểm.");
            } else {
                printWriter.print(" HNX-INDEX tăng.");
            }
        }

        printWriter.println();
    }
}
