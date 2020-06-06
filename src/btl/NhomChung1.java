/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.DSChiSo;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public abstract class NhomChung1 implements NhomChung{
    protected DSChiSo csVNINDEX;
    protected DSChiSo csUPCOMINDEX;
    protected DSChiSo csHNXINDEX;
    protected DSChiSo csChung;
    protected DSChiSo maTang;
    protected DSChiSo maGiam;
    protected DSChiSo klGD;
    
    public NhomChung1(DSChiSo csChung){
        this.csChung = csChung;
    }
    
    public NhomChung1(DSChiSo maTang,DSChiSo maGiam, DSChiSo klGD, String str){
        this.maTang = maTang;
        this.maGiam = maGiam;
        this.klGD = klGD;
    }
    
    public NhomChung1(DSChiSo chiso1, DSChiSo chiso2, DSChiSo chiso3)
    {
        this.csVNINDEX = chiso1;
        this.csUPCOMINDEX = chiso2;
        this.csHNXINDEX = chiso3;
    }
    
//    @Override
//    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
