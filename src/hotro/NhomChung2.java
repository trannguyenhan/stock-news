/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotro;

import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public abstract class NhomChung2 {
    protected DSChiSo[] dsVNINDEX;
    protected DSChiSo[] dsUPCOMINDEX;
    protected DSChiSo[] dsHNXINDEX;
    public int totalrow;
    
    public NhomChung2(DSChiSo[] dsVNINDEX, DSChiSo[] dsUPCOMINDEX, DSChiSo[] dsHNXINDEX, int totalrow)
    {
        this.dsVNINDEX = dsVNINDEX;
        this.dsUPCOMINDEX = dsUPCOMINDEX;
        this.dsHNXINDEX = dsHNXINDEX;
        this.totalrow = totalrow;
    }
    
    public abstract void printResult(PrintWriter printWriter);
}
