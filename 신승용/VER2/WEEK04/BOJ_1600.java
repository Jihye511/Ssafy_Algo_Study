package 신승용.VER2.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int K, W, H;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[] hdx = {-1,-2,-2,-1,1,2,2,1};
    static int[] hdy = {-2,-1,1,2,-2,-1,1,2};
    static int result;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;

        map = new int[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0, 0});
        boolean[][][] visited = new boolean[H][W][K+1];
        visited[x][y][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int ck = cur[2];
            int count = cur[3];

            if(cx == H-1 && cy == W-1){
                result = Math.min(result, count);
                continue;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if(nx>=0 && ny>=0 && nx<H && ny<W &&
                !visited[nx][ny][ck] && map[nx][ny]!=1){
                    queue.offer(new int[]{nx, ny, ck, count+1});
                    visited[nx][ny][ck] = true;
                }
            }

            if(ck < K){
                for (int i = 0; i < hdx.length; i++) {
                    int nx = cx + hdx[i];
                    int ny = cy + hdy[i];
                    if(nx>=0 && ny>=0 && nx<H && ny<W &&
                    !visited[nx][ny][ck+1] && map[nx][ny]!=1){
                        queue.offer(new int[]{nx, ny, ck+1, count+1});
                        visited[nx][ny][ck+1] = true;
                    }
                }
            } 
                       
        }
    }
}
