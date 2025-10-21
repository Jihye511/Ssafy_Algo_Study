package Baekjoon.WEEK9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for (int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        while (bfs()) cnt++;

        System.out.println(cnt);
    }

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};
    static boolean bfs() {
        boolean f = false;

        boolean[][] v = new boolean[N][N];
        int[][] type = new int[N][N];
        Queue<Pos> que = new ArrayDeque<>();
        int c = 0;
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {

                if (!v[i][j]) {
                    c++;
                    que.add(new Pos(i,j));
                    v[i][j] = true;

                    boolean flag = false;

                    while (!que.isEmpty()) {
                        Pos cur = que.poll();

                        for (int k=0; k<4; k++) {
                            int nr = cur.r+dr[k];
                            int nc = cur.c+dc[k];

                            if (nr>=0&&nr<N&&nc>=0&&nc<N&&!v[nr][nc]) {
                                int sub = Math.abs(arr[cur.r][cur.c]-arr[nr][nc]);

                                if (sub>=L&&sub<=R) {
                                    flag = true;
                                    type[nr][nc] = c;
                                    que.add(new Pos(nr,nc));
                                    v[nr][nc] = true;
                                }
                            }
                        }
                    }

                    if (flag) {
                        f = true;
                        type[i][j] = c;
                    }
                    else c--;
                }
            }
        }

        if (f) {
            int[] sum = new int[c+1];
            int[] cnt = new int[c+1];
            for (int i=0;i<N;i++) {
                for (int j=0;j<N;j++) {
                    sum[type[i][j]]+=arr[i][j];
                    cnt[type[i][j]]++;
                }
            }

            for (int i=1; i<=c; i++) {
                sum[i]/=cnt[i];
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    if (type[i][j]==0) continue;
                    arr[i][j] = sum[type[i][j]];
                }
            }
        }
        return f;
    }
}
