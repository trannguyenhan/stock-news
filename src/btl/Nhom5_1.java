package BTL;

import java.io.PrintWriter;

public class Nhom5_1 extends SetenceGenerator{

    public Nhom5_1(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3) {
        super(chiso1,chiso2,chiso3);
    }

    public void printResult(PrintWriter printWriter) {
        printWriter.print("Theo đó, VN-INDEX đóng cửa ");
        String var10001;
        if (this.csVNINDEX.getChange().charAt(0) != '-') {
            if (this.csVNINDEX.getChange().charAt(0) == '0') {
                var10001 = this.csVNINDEX.getChange();
                printWriter.print("tăng nhẹ " + var10001 + " lên " + this.csVNINDEX.getFinalPrice() + " điểm, ");
            } else {
                var10001 = this.csVNINDEX.getChange();
                printWriter.print("tăng " + var10001 + " lên " + this.csVNINDEX.getFinalPrice() + " điểm, ");
            }
        } else {
            var10001 = this.csVNINDEX.getFinalPrice();
            printWriter.print("tại mốc tham chiếu " + var10001 + " giảm " + this.csVNINDEX.getChange() + ", ");
        }

        if (this.csHNXINDEX.getChange().charAt(0) == '-' && this.csUPCOMINDEX.getChange().charAt(0) == '-') {
            printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều giảm điểm.");
        } else if (this.csHNXINDEX.getChange().charAt(0) != '-' && this.csUPCOMINDEX.getChange().charAt(0) != '-') {
            printWriter.print("Trong khi HNX-INDEX và UPCOM-INDEX đều đóng cửa trong xắc xanh. ");
        } else if (this.csHNXINDEX.getChange().charAt(0) != '-') {
            printWriter.print("Trong khi HNX-INDEX đóng cửa với xắc xanh thì UPCOM-INDEX lại đóng cửa giảm điểm. ");
        } else {
            printWriter.print("Trong khi HNX-INDEX đóng cửa giảm điểm thì UPCOM-INDEX lại đóng cửa với xắc xanh. ");
        }

        printWriter.println();
    }
}