package 신승용.VER2.WEEK01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_14916 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];

        Arrays.fill(dp, -1);

        if (N >= 2) dp[2] = 1;
        if (N >= 4) dp[4] = 2;
        if (N >= 5) dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            int min = Integer.MAX_VALUE;

            if (dp[i - 2] != -1) min = Math.min(min, dp[i - 2] + 1);
            if (dp[i - 5] != -1) min = Math.min(min, dp[i - 5] + 1);

            dp[i] = (min == Integer.MAX_VALUE) ? -1 : min;
        }

        System.out.println(dp[N]);
    }
}
