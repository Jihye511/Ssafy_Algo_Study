package boj;

import java.util.*;
import java.io.*;

public class BOJ_1520 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dp = new int[N][M];
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
        }
        dfs(0,0);
        System.out.println(dp[0][0]);
    }

    private static int dfs(int r, int c) {
        if(r==N-1&&c==M-1){
            return dp[r][c] = 1;
        }
        if(dp[r][c]!=-1) return dp[r][c];
        int move = 0;
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nc >= 0 && nr < N && nc < M){
                if(map[r][c] > map[nr][nc]){
                    move += dfs(nr,nc);
                }
            }
        }

        return dp[r][c] = move;
    }
}
