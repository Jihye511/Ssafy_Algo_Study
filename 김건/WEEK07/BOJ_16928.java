package Baekjoon.WEEK7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static int[] count;

    static class Pos {
        int p, c;

        Pos(int p) {
            this.p = p;
            this.c = 0;
        }

        Pos(int p, int c) {
            this.p = p;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        int s, e;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());

            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            map[s] = e;
        }

        count = new int[101];

        Queue<Pos> que = new ArrayDeque<>();

        que.add(new Pos(1));

        while (!que.isEmpty()) {
            Pos cur = que.poll();
            if (cur.p == 100) {
                System.out.println(cur.c);
                break;
            }
            if (count[cur.p]!=0&&count[cur.p]<cur.c) continue;
            for (int i=1; i<=6; i++) {
                int np = cur.p + i;
                int nc = cur.c + 1;

                if (np<=100&&(count[np]==0||count[np]>nc)) {
                    count[np] = nc;

                    if (map[np]==0) {
                        que.add(new Pos(np, nc));
                    }
                    else {
                        if (count[map[np]]==0||count[map[np]]>nc) {
                            count[map[np]] = nc;
                            que.add(new Pos(map[np], nc));
                        }
                    }
                }
            }
        }
    }
}
