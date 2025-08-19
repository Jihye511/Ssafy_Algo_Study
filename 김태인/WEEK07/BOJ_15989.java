        import java.util.*;
        import java.io.*;

        public class Main {

            public static int N;
            public static int[][] dp;
            public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                N = Integer.parseInt(br.readLine());
                dp = new int[10001][4];

                dp[1][1] = 1;
                dp[1][2] = 0;
                dp[1][3] = 0;
                dp[2][1] = 1;
                dp[2][2] = 1;
                dp[2][3] = 0;
                dp[3][1] = 1;
                dp[3][2] = 1;
                dp[3][3] = 1;

                for (int i = 4; i < 10001 ; i++) {
                    dp[i][1] = dp[i-1][1];
                    dp[i][2] += dp[i-2][2] + dp[i-2][1];
                    dp[i][3] += dp[i-3][3] + dp[i-3][2] + dp[i-3][1];
                }


                for (int i = 0; i < N; i++) {
                    int ord = Integer.parseInt(br.readLine());
                    System.out.println(dp[ord][1] + dp[ord][2] + dp[ord][3]);
                }
            }
        }
