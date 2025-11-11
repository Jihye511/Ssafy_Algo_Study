package Baekjoon.VER2.WEEK4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {

    static class Node {
        boolean n, s, e, w;

        Node(int N) {
            if ((N&1)!=0) this.w = true;
            if ((N&2)!=0) this.n = true;
            if ((N&4)!=0) this.e = true;
            if ((N&8)!=0) this.s = true;
        }

        public boolean check(int n) {
            switch (n) {
                case 0: {
                    return this.w;
                }
                case 1: {
                    return this.n;
                }
                case 2: {
                    return this.e;
                }
                case 3: {
                    return this.s;
                }
            }
            return false;
        }
    }

    static class Pos {
        int r, c;

        Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int R, C;
    static Node[][] arr;
    static int[][] types;
    static boolean[][] v;
    static Queue<Pos> que;
    static HashMap<Integer, Integer> map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        arr = new Node[R][C];
        types = new int[R][C];
        v = new boolean[R][C];
        que = new ArrayDeque<>();
        map = new HashMap<>();

        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                arr[i][j] = new Node(Integer.parseInt(st.nextToken()));
            }
        }

        int c = 0, max=0, sumMax=0, count;

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (types[i][j]==0) {
                    c++;
                    count = bfs(i,j,c);
                    map.put(c, count);
                    max = Math.max(max, count);
                }
            }
        }

        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (!v[i][j]) {
                    sumMax = Math.max(sumMax, breakBfs(i,j));
                }
            }
        }

        System.out.println(c);
        System.out.println(max);
        System.out.println(sumMax);
    }

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    private static int bfs(int r, int c, int type) {
        que.add(new Pos(r, c));
        types[r][c] = type;
        int nr, nc, count=1;
        while (!que.isEmpty()) {
            Pos cur = que.poll();

            for (int d=0; d<4; d++) {
                nr = cur.r+dr[d];
                nc = cur.c+dc[d];
                if (nr>=0&&nr<R&&nc>=0&&nc<C&&!arr[cur.r][cur.c].check(d)&&types[nr][nc]==0) {
                    types[nr][nc] = type;
                    que.add(new Pos(nr,nc));
                    count++;
                }
            }
        }
        return count;
    }

    private static int breakBfs(int r, int c) {
        que.add(new Pos(r, c));
        v[r][c] = true;
        int type = types[r][c];
        int nr, nc, max=0;
        while (!que.isEmpty()) {
            Pos cur = que.poll();

            for (int d=0; d<4; d++) {
                nr = cur.r+dr[d];
                nc = cur.c+dc[d];
                if (nr>=0&&nr<R&&nc>=0&&nc<C) {
                    if (arr[cur.r][cur.c].check(d)) {
                        if (types[nr][nc]==type) {
                            if (!v[r][c]) {
                                que.add(new Pos(r, c));
                                v[r][c] = true;
                            }
                        }
                        else {
                            max = Math.max(max, map.get(types[nr][nc]));
                        }
                    }
                    else {
                        if (!v[r][c]) {
                            que.add(new Pos(r, c));
                            v[r][c] = true;
                        }
                    }
                }
            }
        }
        return max+map.get(type);
    }
}
