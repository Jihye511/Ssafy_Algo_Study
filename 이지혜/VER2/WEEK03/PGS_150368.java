import java.io.*;
import java.util.*;
class Solution {
    static int[] sales = {10,20,30,40};
    static int totalPrice=0;
    static int totalPeople=0;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        int[] percent = new int[emoticons.length];
        dfs(0, users, percent, emoticons);
        answer[0] = totalPeople;
        answer[1] = totalPrice;
        return answer;
    }
    public static void dfs(int emoIdx, int[][] users, int[] percent, int[]emoticons){
        if(emoIdx == emoticons.length){
            //계산하러 보내기
            int[] cur = calcul(percent, users, emoticons);
            if(cur[0] >= totalPeople){
                if(cur[0] == totalPeople){
                    totalPrice =Math.max(totalPrice,cur[1]);
                }else{
                    totalPeople = cur[0];
                    totalPrice = cur[1];
                }
            }
            return;
        }
        for(int i =0; i<4; i++){
            percent[emoIdx] = sales[i];
            dfs(emoIdx+1, users, percent, emoticons);
            
        }
    }
    //임티플? 개별 이모지? 계산
    public static int[] calcul(int[] percent, int[][] users, int[] emoticons){
        int[] total=new int[2];
        int[] price= new int[users.length];
        for(int i =0; i< percent.length; i++){
            for(int u=0; u<users.length; u++){
                if(percent[i] >=users[u][0]){
                    price[u] += emoticons[i] * (100 - percent[i]) / 100;
                }
                
            }
        }
        //임티플구매자 구하기
        for(int i =0; i<users.length; i++){
            if(price[i] >= users[i][1]){
                total[0] ++;
            }else{
                total[1] += price[i];
            }
        }
        
        return total;
    }
}
