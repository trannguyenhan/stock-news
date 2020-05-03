package BTL;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Nhom6 {
    String[] arr = {"Hết ngày ", "Kết thúc phiên giao dịch ", "Chốt phiên giao dịch ngày ", "Đóng cửa phiên giao dịch "};
    List<String> list = Arrays.asList(arr);
    private RandomItem obj = new RandomItem();
    private String adv = obj.getRandomElement(list);

    ReadFile stockReport = new ReadFile();
    public int[] arr_value;

    public Nhom6() throws IOException {
        arr_value = stockReport.readColumnsExcel("/home/viethoang/Desktop/Stock_report.xlsx");
    }


    public void printResult(PrintWriter printWriter) throws FileNotFoundException {
        printWriter.print(adv + "hôm nay " + "Có " + String.valueOf(arr_value[0]) + " mã tăng " + String.valueOf(arr_value[1]) + " mã giảm chủ yếu là các mindcap. ");
        System.out.println(adv + "hôm nay " + "Có " + String.valueOf(arr_value[0]) + " mã tăng " + String.valueOf(arr_value[1]) +" mã giảm chủ yếu là mindcap. " );
    }

}
