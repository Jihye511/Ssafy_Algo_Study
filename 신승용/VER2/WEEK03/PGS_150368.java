package 신승용.VER2.WEEK03;

import java.util.*;

public class PGS_150368 {
    int N;
    int[] sales = new int[] {10, 20, 30, 40};
    int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        N = emoticons.length;
        dfs(0, new int[N], users, emoticons);
        return answer;
    }
    
    void dfs(int depth, int[] sel, int[][] users, int[] emoticons){
        if(depth == N){
            calc(sel, users, emoticons);
            return;
        }
        
        for(int i=0; i<4; i++){
            sel[depth] = i;
            dfs(depth+1, sel, users, emoticons);
        }
    }
    
    void calc(int[] sel, int[][] users, int[] emoticons){
        
        int ott = 0;
        int total = 0;
                
        for(int[] user : users){
            int rate = user[0];
            int price = user[1];
            int sum = 0;
            boolean join = false;
            
            for(int i=0; i<sel.length; i++){
                if(rate <= sales[sel[i]]){
                    sum += emoticons[i] * (100 - sales[sel[i]]) / 100;
                }
                                
                if(sum >= price){
                    ott++;
                    join = true;
                    break;
                }
            }
            
            if(!join){
                total += sum;
            }
        }
                
        if(answer[0] < ott){
            answer[0] = ott;
            answer[1] = total;
            return;
        } else if(answer[0] == ott){
            if(answer[1] < total){
                answer[1] = total;
            }
            return;
        } else {
            return;
        }
    }
}
