    import java.util.*;
    import java.io.*;

    public class Main {

        static int N, M, result;
        static int[][] arr;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            int[][][] dp = new int[N][M][3];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                    Arrays.fill(dp[i][j], 10001);
                }

            }

            for (int j = 0; j < M; j++) {
                for (int d = 0; d < 3; d++) {
                    dp[0][j][d] = arr[0][j];
                }
            }

            // 0 : 왼쪽, 1 : 바로 위, 2 : 오른쪽
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(j == 0){
                        dp[i][j][1] = dp[i-1][j][2] + arr[i][j];
                        dp[i][j][2] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][0]) + arr[i][j];
                    }
                    else if(j == M-1){
                        dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                        dp[i][j][1] = dp[i-1][j][0] + arr[i][j];
                    }
                    else{
                        dp[i][j][0] = Math.min(dp[i-1][j-1][1], dp[i-1][j-1][2]) + arr[i][j];
                        dp[i][j][1] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + arr[i][j];
                        dp[i][j][2] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][0]) + arr[i][j];
                    }
                }
            }

            result = Integer.MAX_VALUE;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < 3; j++) {
                    result = Math.min(result, dp[N-1][i][j]);
                }

            }
            System.out.println(result);
        }
    }
