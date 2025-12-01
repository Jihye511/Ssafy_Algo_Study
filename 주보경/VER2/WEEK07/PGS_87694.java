import java.util.*;

//지도에 표시
class Solution {
    static boolean[][] map;
    static int[][] dist;
    static int MAX = 102;
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        map = new boolean[MAX][MAX];
        dist = new int[MAX][MAX];
        //좌하 x 좌하 y 우상 x 우상  y
        for (int[] rect : rectangle) {
            int lx = rect[0] * 2;
            int ly = rect[1] * 2;
            
            int rx = rect[2] * 2;
            int ry = rect[3] * 2;
            
            //모든 칸 채우기
            for (int i = lx; i <= rx; i++) {
                for (int j = ly; j <= ry; j++) {
                    map[j][i] = true;
                }
            }
        }
        
        for (int[] rect : rectangle) {
            int lx = rect[0] * 2;
            int ly = rect[1] * 2;
            
            int rx = rect[2] * 2;
            int ry = rect[3] * 2;
            
            //테두리만 남기고 다시 없애기
            for (int i = lx+1; i < rx; i++) {
                for (int j = ly+1; j < ry; j++) {
                    map[j][i] = false;
                } 
            }
        }
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {characterY * 2, characterX * 2});
        
        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};
        while(!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            for (int d = 0; d < 4; d++) {
                int nr = curr[0] + dr[d];
                int nc = curr[1] + dc[d];
                
                if (!inRange(nr,nc)) continue;
                if (!map[nr][nc]) continue;
                if (dist[nr][nc] > 0) continue;
                
                dist[nr][nc] = dist[curr[0]][curr[1]] + 1;
                dq.add(new int[] {nr,nc});
                
            }
        }
        return dist[itemY*2][itemX*2] / 2;
        
    }
    
    static boolean inRange(int r, int c) {
        return 0 <= r && r < MAX && 0 <= c && c < MAX;
    }
}
