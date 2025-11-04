import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] now_server = new int[24];
        
        for(int i = 0; i < 24; i++){
            int need_server = players[i] / m;
            int plus_server = 0;
            if(now_server[i] < need_server){
                plus_server = need_server - now_server[i];
            }
            
            if(plus_server > 0){
                answer += plus_server;
                for(int j = i; j < i + k; j++){
                    if(j >= 24) break;
                    now_server[j] += plus_server;
                }
            }
        
            
            
            
        }
        
        
        return answer;
    }
}
