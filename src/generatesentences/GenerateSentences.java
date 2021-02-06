package generatesentences;

import java.io.IOException;
import java.io.PrintWriter;

import model.*;

/**
 *
 * @author admin
 * Stock specification sentences
 */
public class GenerateSentences {
    ReadFile rfVNINDEX = new ReadFile();
    ReadFile rfUPCOMINDEX = new ReadFile();
    ReadFile rfHNXINDEX = new ReadFile();
    
    public GenerateSentences() throws IOException
    {
        rfVNINDEX.read("result/stock.xlsx",0);
        rfUPCOMINDEX.read("result/stock.xlsx",1);
        rfHNXINDEX.read("result/stock.xlsx",2);
    }
    
    public GenerateSentences(String valueString1, String valueString2, String valueString3) throws IOException // Khi ca 3 file deu duoc lay ve
    {        
        rfVNINDEX.read(valueString1,0);
        rfUPCOMINDEX.read(valueString1,1);
        rfHNXINDEX.read(valueString1,2);
    }    
    
    public void writeResult() throws IOException {    
        PrintWriter printWriter = new PrintWriter("result/ketqua.txt","utf8");
        //PrintWriter printWriter = new PrintWriter( new OutputStreamWriter( "ketqua.txt", StandardCharsets.UTF_8 ) );
        
        // Group 5-0
        for(int i=0; i<rfVNINDEX.totalRow; i++)
        {
            Group5_0 nhom5_0 = new Group5_0(rfVNINDEX.list[i],rfUPCOMINDEX.list[i],rfHNXINDEX.list[i]);
            nhom5_0.printResult(printWriter);
        }
        
        // Group 5-1
        for(int i=0; i<rfUPCOMINDEX.totalRow; i++)
        {
            Group5_1 nhom5_1 = new Group5_1(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_1.printResult(printWriter);
        }
        
        // Group 5-2
        for(int i=0; i<rfUPCOMINDEX.totalRow; i++)
        {
            Group5_2 nhom5_2 = new Group5_2(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_2.printResult(printWriter);
        }
        
        // Group 5-3
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_3 nhom5_3 = new Group5_3(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_3.printResult(printWriter);
        }
        
        // Group 5-4
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_4 nhom5_4 = new Group5_4(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_4.printResult(printWriter);
        }
        
        // Group 5-5
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_5 nhom5_5 = new Group5_5(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_5.printResult(printWriter);
        }
        
        // Group 5-6
        Group5_6 nhom5_6 = new Group5_6(rfVNINDEX.list, rfUPCOMINDEX.list, rfHNXINDEX.list, rfVNINDEX.totalRow);
        nhom5_6.printResult(printWriter);
        
        // Group 5-7
        Group5_7 nhom5_7 = new Group5_7(rfVNINDEX.list, rfUPCOMINDEX.list, rfHNXINDEX.list, rfVNINDEX.totalRow);
        nhom5_7.printResult(printWriter);
        
        // Group 5-8
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_8 nhom5_8 = new Group5_8(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_8.printResult(printWriter);
        }
                    
        // Group 5-28
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_28 nhom5_28 = new Group5_28(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_28.printResult(printWriter);
        }
        
        for(int i=0; i<rfHNXINDEX.totalRow; i++)
        {
            Group5_29 nhom5_29 = new Group5_29(rfVNINDEX.list[i], rfUPCOMINDEX.list[i], rfHNXINDEX.list[i]);
            nhom5_29.printResult(printWriter);
        }
        
        // Group 6-0
        Group6_0 nhom6_0 = new Group6_0(rfVNINDEX, rfUPCOMINDEX, rfHNXINDEX);
        nhom6_0.printResult(printWriter);
        printWriter.println();
        
        // Group 6-1
        Group6_1 nhom6_1 = new Group6_1(rfVNINDEX, rfUPCOMINDEX, rfHNXINDEX);
        nhom6_1.printResult(printWriter);
        printWriter.println();
        
        printWriter.close();
    }
}
