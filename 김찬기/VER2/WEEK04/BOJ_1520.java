package VER2.WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_1520 {

    static int N, M;
    static int[][] map, dp;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; ++i) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M ;++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println(dp[0][0]);
    }

    public static int dfs(int r, int c) {
        if (r == N-1 && c == M-1) {
            return 1;
        }

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        dp[r][c] = 0;

        for (int d=0; d<4; ++d) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];
            if (isValid(nextR, nextC) && map[r][c] > map[nextR][nextC]) {
                dp[r][c] += dfs(nextR, nextC);
            }
        }

        return dp[r][c];
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
