import java.util.*;
import java.io.*;

class Solution {
    static int maxRegister = Integer.MIN_VALUE;
    static int maxRevenue = Integer.MIN_VALUE;
    
    public int[] solution(int[][] users, int[] emoticons) {
        
        recursive(0, new int[emoticons.length], users, emoticons);
   
        return new int[] {maxRegister, maxRevenue}; 
    }
    
    public void recursive(int idx, int[] discount, int[][] users, int[] emoticons){
        if(idx==discount.length){
            int register = 0;
            int revenue = 0;
            for(int[] user : users){
                int discountRateUser = user[0];
                int PurchaseSum = user[1];
                int sum = 0;
                for(int i = 0; i < discount.length; i++){
                    if(discount[i] >= discountRateUser){
                        sum += (emoticons[i] * (100 - discount[i])) / 100;
                    }
                }
                if(sum >= PurchaseSum){
                        register++;
                    }else{
                        revenue += sum;
                    }
            }
            
            if(register > maxRegister){
                maxRegister = register;
                maxRevenue = revenue;
            }else if(register == maxRegister){
                if(revenue > maxRevenue){
                    maxRegister = register;
                    maxRevenue = revenue;
                }
            }
            
            return ;
        }
        
        for(int i = 10; i <= 40; i += 10){
            discount[idx] = i;
            recursive(idx+1, discount, users, emoticons);
        }
    }
}