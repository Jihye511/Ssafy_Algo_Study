import java.util.*;
import java.io.*;

public class Boj_2631_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] child = new int[N];
        for (int i = 0; i < N; i++) {
            child[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[N]; //i번째까지의 최장증가부분수열 길이
        int max = -1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (child[i] > child[j]){
                    //증가함
                    dp[i] = Math.max(dp[i],  dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(N - max);
    }
}
