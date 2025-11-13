import java.io.*;
import java.util.*;

public class Main {
    static int M,N;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[M][N];
        for(int i =0; i<M; i++){
            Arrays.fill(dp[i],-1);
        }

        System.out.println(dfs(0,0));

    }
    static int[][]dp;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    public static int dfs(int x, int y){
        if(x == M-1 && y ==N-1) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        int cnt = 0;
        for(int i =0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=M || ny<0 || ny>=N) continue;
            if(map[nx][ny] >= map[x][y]) continue;

            cnt +=dfs(nx,ny);
        }
        dp[x][y] = cnt;
        return cnt;
    }
}
