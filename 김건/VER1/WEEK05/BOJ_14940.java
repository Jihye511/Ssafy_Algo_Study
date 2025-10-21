package Baekjoon.WEEK5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static class Pos {
        int r, c, d;

        Pos() {

        }

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Pos(int r, int c, int d) {
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Pos s = new Pos();
        int[][] arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j]==2) s = new Pos(i, j);
            }
        }
        int[][] ans = new int[N][M];
        boolean[][] v= new boolean[N][M];
        Queue<Pos> q = new ArrayDeque<>();
        q.add(s);
        v[s.r][s.c] = true;

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            ans[cur.r][cur.c] = cur.d;

            for (int d=0; d<4; d++) {
                int nr = cur.r+dr[d];
                int nc = cur.c+dc[d];

                if (nr>=0&&nr<N&&nc>=0&&nc<M&&!v[nr][nc]&&arr[nr][nc]==1) {
                    q.add(new Pos(nr,nc, cur.d+1));
                    v[nr][nc] = true;
                }
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (ans[i][j]==0&&arr[i][j]==1&&!(i==s.r&&j==s.c)) sb.append(-1);
                else sb.append(ans[i][j]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
