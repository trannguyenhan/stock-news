package btl;

import hotro.DSChiSo;
import hotro.NhomChung1;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Nhom6_0 extends NhomChung1{
    
    public Nhom6_0(DSChiSo csChung) throws IOException {
        super(csChung);
    }


    public void printResult(PrintWriter printWriter) throws FileNotFoundException {
        printWriter.print("hôm nay " + "Có " + csChung.getInc() + " mã tăng " + csChung.getDec() + " mã giảm chủ yếu là các mindcap. ");
//        System.out.println(adv + "hôm nay " + "Có " + String.valueOf(arr_value[0]) + " mã tăng " + String.valueOf(arr_value[1]) +" mã giảm chủ yếu là mindcap. " );
        printWriter.print("\n");

    }

}