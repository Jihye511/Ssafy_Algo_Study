package boj;

import java.util.*;
import java.io.*;

public class BOJ_2169 {
    static int R, C;
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        dp = new int[R][C];

        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int r = 0; r < R; r++){
            Arrays.fill(dp[r], Integer.MIN_VALUE);
        }

        dp[0][0] = map[0][0];
        for(int c = 1; c < C; c++){
            dp[0][c] = dp[0][c-1] + map[0][c];
        }
        int[][] temp = new int[2][C];
        for(int r = 1; r < R; r++){
            temp[0][0] = dp[r-1][0] + map[r][0];
            for(int c = 1; c < C; c++) {
                temp[0][c] = Math.max(dp[r - 1][c], temp[0][c - 1]) + map[r][c];
            }
            temp[1][C-1] = dp[r-1][C-1] + map[r][C-1];
            for(int c = C - 2; c >= 0; c--){
                temp[1][c] = Math.max(dp[r-1][c], temp[1][c+1]) + map[r][c];
            }
            for(int c = 0; c < C; c++){
                dp[r][c] = Math.max(temp[0][c], temp[1][c]);
            }
        }

        System.out.println(dp[R-1][C-1]);
    }


}
