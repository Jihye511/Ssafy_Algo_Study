import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] queries = new int[t];
        int maxN = 0;
        for(int i =0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            queries[i] = n;
            if (n > maxN) maxN = n;
        }
        int[] dp = new int[maxN + 1];
        dp[0] = 1;
        int[] coins = {1, 2, 3};
        for (int c : coins) {
            for (int i = c; i <= maxN; i++) {
                dp[i] += dp[i - c];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n : queries) {
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb);
    }
}
