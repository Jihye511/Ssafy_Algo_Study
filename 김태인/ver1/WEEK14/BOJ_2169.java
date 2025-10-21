import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y, weight;
        Node(int x, int y, int weight){
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {0, 0, 1};
    static int[] dy = {1, -1, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }

        dp[0][0] = map[0][0];

        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];

            left[0] = dp[i-1][0] + map[i][0];
            for (int j = 1; j < M; j++) {
                left[j] = Math.max(left[j-1], dp[i-1][j]) + map[i][j];
            }

            right[M-1] = dp[i-1][M-1] + map[i][M-1];
            for (int j = M-2; j >= 0 ; j--) {
                right[j] = Math.max(right[j+1], dp[i-1][j]) + map[i][j];
            }

            for (int j = 0; j < M; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }

        }

        System.out.println(dp[N-1][M-1]);


    }
}
