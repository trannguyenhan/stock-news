/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author admin
 */
public class RandomSentence {
    
    private List<String> list1;
    private List<String> list2;
    
    public RandomSentence()
    {
        list1 = new ArrayList<>();
        list1.add("Tại thời điểm");
        list1.add("Đóng cửa phiên giao dịch");
        list1.add("Tạm dừng phiên giao dịch");
        list1.add("Tính đến");
        list1.add("Hết ngày");
        list1.add("Kết thúc phiên giao dịch ngày");
        
        list2 = new ArrayList<>();
        list2.add("Trong khi");
        list2.add("Theo đó");
    }
    
    public String getRandomString1()
    {
        Random rand = new Random();
        return list1.get(rand.nextInt(list1.size()));
    }
    
    public String getRandomString2()
    {
    	Random rand = new Random();
        return list2.get(rand.nextInt(list2.size()));
    }
    
}
