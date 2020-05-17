/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotro;

/**
 *
 * @author admin
 */
public class DoiCachDoc {
    //Doi cach doc : vi du 38,000,012 -> doc sap xi thanh 38 trieu
    // Hay 38,912,123,412 -> doc sap xi thanh 38 ty
    public String doiCachDoc(String str)
    {
        String tempString = null;
        int dem = 0;
        for (int i=0; i<str.length(); i++)
            if(str.charAt(i) == ',') dem++;
        
        if (dem == 2)
        {
            int i;
            for(i=0; i<str.length(); i++)
                if(str.charAt(i) == ',') break;
            
            tempString = str.substring(0, i);
            tempString = tempString + " triệu";
        } else 
        if (dem == 3)
        {
            int i;
            for (i=0; i<str.length(); i++)
                if(str.charAt(i) == ',') break;
            
            tempString = str.substring(0,i);
            tempString = tempString + " tỷ";
        } else if(dem ==4)
        {
            int i, j;
            for (i=0; i<str.length(); i++)
                if(str.charAt(i) == ',') break;
            for (j=i+1; j<str.length(); j++)
                if(str.charAt(j) == ',') break;
            
            tempString = str.substring(0,j);
            tempString = tempString + " tỷ";
        } else 
            tempString = str;
    
        return tempString;
    }
}
