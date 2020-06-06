/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.ReadFile;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public abstract class NhomChung3 implements NhomChung{
    protected ReadFile rfVNINDEX;
    protected ReadFile rfUPCOMINDEX;
    protected ReadFile rfHNXINDEX;
    
    public NhomChung3(ReadFile rfVNINDEX, ReadFile rfUPCOMINDEX, ReadFile rfHNXINDEX) {
        this.rfVNINDEX = rfVNINDEX;
        this.rfUPCOMINDEX = rfUPCOMINDEX;
        this.rfHNXINDEX = rfHNXINDEX;
    }
    
//    public abstract void printResult(PrintWriter printWriter);
}
