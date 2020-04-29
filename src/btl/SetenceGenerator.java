package BTL;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public abstract class SetenceGenerator {
    DSChiSo csVNINDEX;
    DSChiSo csUPCOMINDEX;
    DSChiSo csHNXINDEX;

    public SetenceGenerator(DSChiSo csVNINDEX, DSChiSo csUPCOMINDEX, DSChiSo csHNXINDEX) {
        this.csVNINDEX = csVNINDEX;
        this.csUPCOMINDEX = csUPCOMINDEX;
        this.csHNXINDEX = csHNXINDEX;
    }
    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
