package Baekjoon.WEEK7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_15989 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[] {0, 1, 1, 1, 1, 2};
        int maxN = 0;
        int[] ans = new int[N];

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(br.readLine());
            maxN = Math.max(maxN, n);
            ans[i] = n;
        }

        int[] dp = new int[maxN+1];

        dp[0] = 1;

        for (int i =1; i<=maxN; i++) {
            dp[i] = dp[i-1]+arr[(i-1)%6]+(i-1)/6;
        }

        for (int i=0; i<N; i++) {
            System.out.println(dp[ans[i]]);
        }
    }
}
