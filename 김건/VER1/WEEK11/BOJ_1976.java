package Baekjoon.WEEK11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int N, M;
    static boolean[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        map = new boolean[N+1][N+1];

        StringTokenizer st;

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=N; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }
        Queue<Integer> que = new ArrayDeque<>();

        for (int i=1; i<=N; i++) {
            boolean[] v = new boolean[N+1];
            v[i] = true;
            map[i][i] = true;
            for (int j=1; j<=N; j++) {
                if (map[i][j]) {
                    que.add(j);
                    v[j] = true;
                }
            }
            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int j=1; j<=N; j++) {
                    if (!map[i][j]&&map[cur][j]&&!v[j]) {
                        que.add(j);
                        map[i][j] = true;
                        v[j] = true;
                    }
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        int s = Integer.parseInt(st.nextToken());
        boolean f = false;
        for (int i=0; i<M-1; i++) {
            int nx = Integer.parseInt(st.nextToken());
            if (!map[s][nx]) {
                f = true;
                break;
            }
        }

        if (!f) System.out.println("YES");
        else System.out.println("NO");
    }
}
