package 신승용.VER2.WEEK02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N+1];
        int[] values = new int[N+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            weights[i] = w;
            values[i] = v;
        }

        int[][] dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                int w = weights[i];
                int v = values[i];

                if(j < w){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w] + v);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
