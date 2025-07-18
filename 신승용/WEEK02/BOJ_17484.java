import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][][] dp = new int[N][M][3];

        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 3; j++) {
                dp[0][i][j] = arr[0][i];
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int num0 = Integer.MAX_VALUE;
                if (j+1 < M) {
                    num0 = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]);
                }

                int num1 = Math.min(dp[i-1][j][0], dp[i-1][j][2]);

                int num2 = Integer.MAX_VALUE;
                if (j-1 >= 0) {
                    num2 = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]);
                }

                if(num0 != Integer.MAX_VALUE){
                    dp[i][j][0] = num0 + arr[i][j];
                }
                if(num1 != Integer.MAX_VALUE){
                    dp[i][j][1] = num1 + arr[i][j];
                }
                if(num2 != Integer.MAX_VALUE){
                    dp[i][j][2] = num2 + arr[i][j];
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int j = 0; j < M; j++) {
            for (int d = 0; d < 3; d++) {
                answer = Math.min(answer, dp[N-1][j][d]);
            }
        }
        System.out.println(answer);
    }
}