/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public abstract class NhomChung {
    protected DSChiSo csVNINDEX;
    protected DSChiSo csUPCOMINDEX;
    protected DSChiSo csHNXINDEX;
    
    public NhomChung(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        this.csVNINDEX = chiso1;
        this.csUPCOMINDEX = chiso2;
        this.csHNXINDEX = chiso3;
    }
    
    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
