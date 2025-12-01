import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int[][] map = new int[101][101];
        
        for(int[] point : rectangle){
            int sX = point[0] * 2;
            int sY = point[1] * 2;
            int eX = point[2] * 2;
            int eY = point[3] * 2;
            
            for(int i=sX; i<=eX; i++){
                map[sY][i] = 1;
                map[eY][i] = 1;
            }
            
            for(int i=sY; i<=eY; i++){
                map[i][sX] = 1;
                map[i][eX] = 1;
            }
        }
        
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                for(int[] point : rectangle){
                    int sX = point[0] * 2;
                    int sY = point[1] * 2;
                    int eX = point[2] * 2;
                    int eY = point[3] * 2;
                    
                    if(j > sX && j < eX && i > sY
                      && i < eY){
                        map[i][j] = 0;
                    }
                }
            }
        }
        
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{characterY*2, characterX*2, 0});
        boolean[][] visited = new boolean[101][101];
        visited[characterY*2][characterX*2] = true;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cy = cur[0];
            int cx = cur[1];
            int cnt = cur[2];
            
            if(cx==itemX*2 && cy==itemY*2){
                answer = cnt/2;
                break;
            }
            
            for(int i=0; i<dx.length; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx>=0 && nx<101 && ny>=0 && ny<101
                  && map[ny][nx]==1 && !visited[ny][nx]){
                    queue.offer(new int[]{ny, nx, cnt+1});
                    visited[ny][nx] = true;
                }
            }
        }
        

        return answer;
    }
}