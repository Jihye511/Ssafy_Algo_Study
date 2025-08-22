package WEEK07;

import java.io.*;
import java.util.*;

public class BOJ_15989 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[10001][4];
            dp[1][1] = 1;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;

            for (int i = 4; i <= N; ++i) {
                dp[i][1] = dp[i - 1][1];
                dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
                dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
            }
            System.out.println(dp[N][1] + dp[N][2] + dp[N][3]);

        }
    }
}
