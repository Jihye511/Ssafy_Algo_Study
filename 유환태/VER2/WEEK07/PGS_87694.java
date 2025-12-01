import java.util.*;
import java.io.*;

class Solution {
    static class Player implements Comparable<Player> {
        int r;
        int c;
        int d;
        Player(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }
        
        @Override
        public int compareTo(Player o) {
            return this.d - o.d;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
   public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[102][102];
       boolean[][] v = new boolean[102][102];
       for(int[] rec : rectangle){
           int x1 = rec[0] * 2;
           int y1 = rec[1] * 2;
           int x2 = rec[2] * 2;
           int y2 = rec[3] * 2;
           for(int r = y1; r <= y2; r++){
                   map[r][x1]++;
                   map[r][x2]++;
           }
           for(int c = x1; c <= x2; c++){
                   map[y1][c]++;
                   map[y2][c]++;
            }
       }
       PriorityQueue<Player> pq = new PriorityQueue<>();
        pq.add(new Player(characterY * 2, characterX * 2, 0));
        v[characterY * 2][characterX * 2] = true;
       
       while(!pq.isEmpty()){
           Player cur = pq.poll();
           
           if(cur.r == itemY * 2 && cur.c == itemX * 2){
               answer = cur.d;
               break;
           }
           
           for(int d = 0; d < 4; d++){
               int nr = cur.r + dr[d];
               int nc = cur.c + dc[d];
               
               if(nr >= 0 && nc >= 0 && nr < 102 && nc < 102 && !v[nr][nc] && map[nr][nc] != 0){
                   if(isLine(rectangle, nr, nc)){
                       pq.add(new Player(nr, nc, cur.d + 1));
                       v[nr][nc] = true; 
                   }
               }
           }
           
       }
       
        return answer / 2; 
    }
    public boolean isLine(int[][] rectangle, int nr, int nc){
        boolean valid = true;
        
        for(int[] rec : rectangle){
            int x1 = rec[0] * 2;
           int y1 = rec[1] * 2;
           int x2 = rec[2] * 2;
           int y2 = rec[3] * 2;
            if(nr > y1 && nr < y2 && nc > x1 && nc < x2){
                valid = false;
            }
        }
        
        return valid;
    }
}