import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[][] knapsack;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 0 : 무게, 1 : 가치
        knapsack = new int[N+1][2];
        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            knapsack[i][0] = W;
            knapsack[i][1] = V;
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= knapsack[i][0]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j - knapsack[i][0]] + knapsack[i][1]);
                }
            }
        }

        System.out.println(dp[N][K]);





    }
}
