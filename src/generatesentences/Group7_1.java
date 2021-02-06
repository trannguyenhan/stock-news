package generatesentences;
import java.io.PrintWriter;

import model.*;

public class Group7_1 extends GeneralGroup1 {

    public Group7_1(DayTrading maTang, DayTrading maGiam, DayTrading klGD) {
        super(maTang, maGiam, klGD, "Hoang");
    }
    
    public void printResult(PrintWriter printWriter) {
            printWriter.print("Các mã tăng nổi bật trong phiên hôm nay có: " + maTang.getStock_name().get(0) +" , " + maTang.getStock_name().get(1) + " , " + maTang.getStock_name().get(2) + "...");
            printWriter.print(" trong khi đó thì các mã giảm nhiều nhất bao gồm: " +maGiam.getStock_name().get(0)+" , " + maGiam.getStock_name().get(1) + " , " + maGiam.getStock_name().get(2) + "...");
            printWriter.print("\nCác nhóm cổ phiếu được giao dịch nhiều nhất trong ngày có: " + klGD.getStock_name().get(0) + "( " + klGD.getCompany_name().get(0) + ")" + " , " +  klGD.getStock_name().get(1) + "( " + klGD.getCompany_name().get(1) + ")" + " , " + klGD.getStock_name().get(2) + "( " + klGD.getCompany_name().get(2) + ")"  );
            printWriter.print("\nGiao dịch với khối lượng lớn nhất trong ngày là mã  " + klGD.getStock_name().get(0) + " đạt " +klGD.getStock_weight().get(0) +" cổ phiếu " );
            printWriter.print("\nTheo sau đó là mã " + klGD.getStock_name().get(1) + " với khối lượng giao dịch đạt " + klGD.getStock_weight().get(1)+" cổ phiếu.");
            printWriter.print(" Đứng thứ 3 trong ngày hôm nay là cổ phiếu " + klGD.getStock_name().get(2) + " đạt " + klGD.getStock_weight().get(2) + " cổ phiếu");
            printWriter.print("\nMã cổ phiếu: " + maTang.getStock_name().get(0) + "( " + maTang.getCompany_name().get(0) +" )" + " đạt tỉ lệ tăng lớn nhất trong ngày  với mức " +maTang.getChange_percentage().get(0) );
            printWriter.print("\nỞ chiều hướng ngược lại có sự giảm của các mã: " + maGiam.getStock_name().get(0) + " , " + maGiam.getStock_name().get(1) + " , " + maGiam.getStock_name().get(2) + "với mức giảm lần lượt là " + maGiam.getChange_percentage().get(0) +" , " + maGiam.getChange_percentage().get(1) + " , " + maGiam.getChange_percentage().get(2) );
    }
}