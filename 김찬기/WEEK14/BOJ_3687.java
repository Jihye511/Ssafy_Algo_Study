package WEEK14;

import java.io.*;
import java.util.*;

public class BOJ_3687 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;

        int[] count = {1, 7, 4, 2, 0, 8};
        for (int i = 9; i <= 100; ++i) {
            for (int j = 2; j <= 7; ++j) {
                dp[i] = Math.min((dp[i-j] * 10) + count[j-2], dp[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; ++t) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ");

            if (n % 2 == 0) {
                sb.append(getMax(n/2));
            }
            else {
                sb.append("7").append(getMax((n-3)/2));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static String getMax(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; ++i) {
            sb.append(1);
        }

        return sb.toString();
    }
}