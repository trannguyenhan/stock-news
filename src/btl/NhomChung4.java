/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package btl;

import hotro.DSChiSoStockCode;
import hotro.ReadFileStockCode;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author admin
 */
public abstract class NhomChung4 implements NhomChung{
    protected ReadFileStockCode rfStockCode;
    protected DSChiSoStockCode dsStockCode;
    
    public NhomChung4(ReadFileStockCode rfStockCode) {
        this.rfStockCode = rfStockCode;
    }
    
    public NhomChung4(DSChiSoStockCode dsStockCode)
    {
        this.dsStockCode = dsStockCode;
    }
    
//    public abstract void printResult(PrintWriter printWriter) throws FileNotFoundException;
}
