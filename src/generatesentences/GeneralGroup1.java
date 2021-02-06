/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generatesentences;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import model.DayTrading;

/**
 *
 * @author admin
 */
public abstract class GeneralGroup1 implements GeneralGroup{
    protected DayTrading csVNINDEX;
    protected DayTrading csUPCOMINDEX;
    protected DayTrading csHNXINDEX;
    protected DayTrading csChung;
    protected DayTrading maTang;
    protected DayTrading maGiam;
    protected DayTrading klGD;
    
    public GeneralGroup1(DayTrading csChung){
        this.csChung = csChung;
    }
    
    public GeneralGroup1(DayTrading maTang,DayTrading maGiam, DayTrading klGD, String str){
        this.maTang = maTang;
        this.maGiam = maGiam;
        this.klGD = klGD;
    }
    
    public GeneralGroup1(DayTrading chiso1, DayTrading chiso2, DayTrading chiso3)
    {
        this.csVNINDEX = chiso1;
        this.csUPCOMINDEX = chiso2;
        this.csHNXINDEX = chiso3;
    }
    
//    @Override
//    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
