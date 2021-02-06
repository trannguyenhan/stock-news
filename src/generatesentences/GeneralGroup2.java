/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.PrintWriter;

import model.DayTrading;

/**
 *
 * @author admin
 */
public abstract class GeneralGroup2 implements GeneralGroup{
    protected DayTrading[] dsVNINDEX;
    protected DayTrading[] dsUPCOMINDEX;
    protected DayTrading[] dsHNXINDEX;
    public int totalrow;
    
    public GeneralGroup2(DayTrading[] dsVNINDEX, DayTrading[] dsUPCOMINDEX, DayTrading[] dsHNXINDEX, int totalrow)
    {
        this.dsVNINDEX = dsVNINDEX;
        this.dsUPCOMINDEX = dsUPCOMINDEX;
        this.dsHNXINDEX = dsHNXINDEX;
        this.totalrow = totalrow;
    }
    
//    public abstract void printResult(PrintWriter printWriter);
}
