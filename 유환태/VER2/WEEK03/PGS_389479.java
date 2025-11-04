import java.util.*;
import java.io.*;

class Solution {

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Queue<Integer> servers = new ArrayDeque<>();
        
        int server = 0;
        
        for(int player : players){

            if(player/m > server){
                int need = player/m - server;
                for(int i = 0; i < need; i++){
                    servers.add(k);
                    server += 1;
                    answer += 1;
                }
            }
            int size  = servers.size();
            for(int i = 0; i < size; i++){
                int cur = servers.poll();
                cur -= 1;
                if(cur > 0){
                    servers.add(cur);
                }else{
                    server -= 1;
                }
            }

        }
        
        return answer;
    }
}