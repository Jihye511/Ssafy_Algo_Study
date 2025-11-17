import java.io.*;
import java.util.*;

public class Main {

    static int V, E;
    static int[][] dp;
    static int max_val = 1000000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dp = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(dp[i], max_val);
            dp[i][i] = 0;
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            dp[a][b] = Math.min(dp[a][b], c);
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dp[i][k] + dp[k][j] < dp[i][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        int result = max_val;

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) continue;
                if (dp[i][j] < max_val && dp[j][i] < max_val) {
                    result = Math.min(result, dp[i][j] + dp[j][i]);
                }
            }
        }
        
        if (result == max_val) System.out.println(-1);
        else System.out.println(result);
    }
}
