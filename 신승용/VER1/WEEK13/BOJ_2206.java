package 신승용.WEEK13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {

    static int N;
    static int M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String token = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(token.charAt(j)+"");
            }
        }

        bfs(0, 0);
    }

    static void bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y, 0, 1});
        boolean[][][] visited = new boolean[N][M][2];
        visited[x][y][0] = true;
        
        boolean isValid = false;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int dis = cur[2];
            int breakCnt = cur[3];

            if(cx == N-1 && cy == M-1){
                System.out.println(dis+1);
                isValid = true;
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if(nx >=0 && nx<N && ny>=0 && ny<M 
                && !visited[nx][ny][breakCnt] && map[nx][ny]==0){
                    queue.offer(new int[]{nx, ny, dis+1, breakCnt});
                    visited[nx][ny][breakCnt] = true;
                }
                if(nx >=0 && nx<N && ny>=0 && ny<M 
                && !visited[nx][ny][breakCnt] && map[nx][ny]==1 && breakCnt > 0){
                    queue.offer(new int[]{nx, ny, dis+1, breakCnt-1});
                    visited[nx][ny][breakCnt] = true;
                }
            }
        }

        if(!isValid){
            System.out.println(-1);
        }
    }
}
