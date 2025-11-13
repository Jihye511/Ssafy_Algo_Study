package Baekjoon.VER2.WEEK4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1600 {
    static int K, N, M;
    static boolean[][] map;
    static boolean[][][] v;

    static class Pos {
        int r, c, d, k;

        Pos(int r, int c, int d, int k) {
            this.r = r;
            this.c = c;
            this.d = d;
            this.k = k;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new boolean[N][M];
        v = new boolean[N][M][K+1];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<M; j++) {
                if (st.nextToken().charAt(0)=='1')
                    map[i][j]=true;
            }
        }
        bfs();
    }

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int[] hdr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hdc = {-2, -1, 1, 2, 2, 1, -1, -2};

    static void bfs() {
        Queue<Pos> que = new ArrayDeque<>();
        que.add(new Pos(0,0, 0, 0));
        v[0][0][0] = true;
        int nr, nc, nd, nk, er = N-1, ec = M-1;
        while (!que.isEmpty()) {
            Pos cur = que.poll();

            if (cur.r==er&&cur.c==ec) {
                System.out.println(cur.d);
                return;
            }
            L:for (int d=0; d<4; d++) {
                nr = cur.r+dr[d];
                nc = cur.c+dc[d];
                nd = cur.d+1;
                if (nr>=0&&nr<N&&nc>=0&&nc<M&&!map[nr][nc]) {
                    for (int k=0; k<=cur.k; k++) {
                        if (v[nr][nc][k])  continue L;
                    }

                    que.add(new Pos(nr, nc, nd, cur.k));
                    v[nr][nc][cur.k] = true;
                }
            }

            if (cur.k < K) {
                L:for (int d = 0; d < 8; d++) {
                    nr = cur.r + hdr[d];
                    nc = cur.c + hdc[d];
                    nd = cur.d + 1;
                    nk = cur.k + 1;
                    if (nr>=0&&nr<N&&nc>=0&&nc<M&&!map[nr][nc]) {
                        for (int k=0; k<=nk; k++) {
                            if (v[nr][nc][k]) continue L;
                        }

                        que.add(new Pos(nr, nc, nd, nk));
                        v[nr][nc][nk] = true;
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
