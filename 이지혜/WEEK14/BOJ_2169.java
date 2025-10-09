import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                while (!st.hasMoreTokens()) st = new StringTokenizer(br.readLine());
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][m];
        int[][] temp = new int[m][2];

        dp[0][0] = arr[0][0];
        for (int j = 1; j < m; ++j)
            dp[0][j] = dp[0][j - 1] + arr[0][j];

        for (int i = 1; i < n; ++i) {
            temp[0][0] = dp[i - 1][0] + arr[i][0];
            temp[m - 1][1] = dp[i - 1][m - 1] + arr[i][m - 1];

            for (int j = 1; j < m; ++j)
                temp[j][0] = Math.max(dp[i - 1][j], temp[j - 1][0]) + arr[i][j];


            for (int j = m - 2; j >= 0; --j)
                temp[j][1] = Math.max(dp[i - 1][j], temp[j + 1][1]) + arr[i][j];

            for (int j = 0; j < m; ++j)
                dp[i][j] = Math.max(temp[j][0], temp[j][1]);
        }

        System.out.println(dp[n - 1][m - 1]);
    }
}
