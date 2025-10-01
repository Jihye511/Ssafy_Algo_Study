package Baekjoon.WEEK13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2206 {
    static int N, M;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i=0; i<N; i++) {
            String in = br.readLine();
            for (int j=0; j<M; j++) {
                map[i][j] = in.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int bfs() {
        Queue<int []> que = new ArrayDeque<>();
        boolean[][][] v = new boolean[2][N][M];
        int r=N-1;
        int c=M-1;
        que.add(new int[] {0,0,0,1});

        v[0][0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0]==r&&cur[1]==c) {
                return cur[3];
            }
            L:for (int d=0; d<4; d++) {
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];

                if (nr>=0&&nr<N&&nc>=0&&nc<M) {
                    for (int i=0; i<=cur[2]; i++) {
                        if (v[i][nr][nc]) continue L;
                    }

                    if (map[nr][nc]==0) {
                        que.add(new int[] {nr, nc, cur[2], cur[3]+1});
                        v[cur[2]][nr][nc] = true;
                    }
                    else {
                        if (cur[2]==0) {
                            que.add(new int[] {nr, nc, 1, cur[3]+1});
                            v[1][nr][nc] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}
