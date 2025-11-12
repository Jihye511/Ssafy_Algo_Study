package Baekjoon.VER2.WEEK4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class BOJ_1520 {
    static int N, M;
    static int[][] map;
    static int[][] dp;
    static Pos[] poss;

    static class Pos implements Comparable<Pos> {
        int r, c, h;

        public Pos(int r, int c, int h) {
            super();
            this.r = r;
            this.c = c;
            this.h = h;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(o.h, this.h);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        poss = new Pos[N * M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                poss[i * M + j] = new Pos(i, j, map[i][j]);
            }
        }
        Arrays.sort(poss);
        int r, c, nr, nc;
        dp[0][0] = 1;
        for (int i = 0; i < N * M; i++) {
            r = poss[i].r;
            c = poss[i].c;
            for (int d = 0; d < 4; d++) {
                nr = r + dr[d];
                nc = c + dc[d];
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[r][c] < map[nr][nc]) {
                    dp[r][c] += dp[nr][nc];
                }
            }
        }
        System.out.println(dp[N - 1][M - 1]);

    }

    static int[] dr = { 0, 0, 1, -1 };
    static int[] dc = { 1, -1, 0, 0 };
}

