import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        Queue<Integer> q= new LinkedList<>();
        int server=0;
        for(int i =0; i<players.length; i++){
            int people = players[i];
            //서버 수 다시 계산
            int n = q.size();
            for(int j =0; j<n; j++){
                int cur= q.poll();
                if(cur-1 ==0) continue;
                else{
                    q.offer(cur-1);
                }
            }
            
            
            if(q.size() < people / m){
                answer += people/m - q.size(); 
                while(q.size()< people/m){
                    q.offer(k);
                }
            }
        }
        return answer;
    }
}
