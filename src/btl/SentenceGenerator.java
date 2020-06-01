package BTL;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
public abstract class SentenceGenerator {
    DSChiSo klGD;
    DSChiSo csVNINDEX;
    DSChiSo csUPCOMINDEX;
    DSChiSo csHNXINDEX;
    DSChiSo csChung;
    DSChiSo maTang;
    DSChiSo maGiam;

//    public SentenceGenerator(DSChiSo csVNINDEX, DSChiSo csUPCOMINDEX, DSChiSo csHNXINDEX) {
//        this.csVNINDEX = csVNINDEX;
//        this.csUPCOMINDEX = csUPCOMINDEX;
//        this.csHNXINDEX = csHNXINDEX;
//    }

    public SentenceGenerator(DSChiSo csChung){
        this.csChung = csChung;
    }

    public SentenceGenerator(DSChiSo maTang,DSChiSo maGiam, DSChiSo klGD){
        this.maTang = maTang;
        this.maGiam = maGiam;
        this.klGD = klGD;
    }

    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
