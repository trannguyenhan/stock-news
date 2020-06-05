package btl;

import hotro.DSChiSo;
import hotro.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Nhom7_0 extends NhomChung4{
    
    public Nhom7_0(DSChiSoStockCode csChung) throws IOException {
        super(csChung);
    }


    @Override
    public void printResult(PrintWriter printWriter) throws FileNotFoundException {
        printWriter.print("hôm nay " + "Có " + dsStockCode.getInc() + " mã tăng " + dsStockCode.getDec() + " mã giảm chủ yếu là các mindcap. ");
//        System.out.println(adv + "hôm nay " + "Có " + String.valueOf(arr_value[0]) + " mã tăng " + String.valueOf(arr_value[1]) +" mã giảm chủ yếu là mindcap. " );
        printWriter.print("\n");

    }

}