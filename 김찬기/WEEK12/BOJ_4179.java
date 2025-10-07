package WEEK12;

import java.io.*;
import java.util.*;

public class BOJ_4179 {

    static class Node {
        int r;
        int c;
        int cnt;

        public Node() {}
        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
        public Node(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }

    static int R, C;
    static char[][] map;
    static Queue<Node> jq, fq;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};


    public static void main(String[] args) throws  Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        jq = new ArrayDeque<>();
        fq = new ArrayDeque<>();

        map = new char[R][C];
        for (int i=0; i<R; ++i) {
            String s = br.readLine();
            for (int j=0; j<C; ++j) {
                map[i][j] = s.charAt(j);
                if (map[i][j] == 'J') {
                    jq.add(new Node(i, j));
                }
                else if (map[i][j] == 'F') {
                    fq.add(new Node(i, j));
                }
            }
        }

        int result = bfs();

        if (result == -1) {
            System.out.println("IMPOSSIBLE");
        }
        else {
            System.out.println(result);
        }
    }

    public static int bfs() {
        while (!jq.isEmpty()) {
            int fl = fq.size();
            for (int i=0; i<fl; ++i) {
                Node fire = fq.poll();
                for (int d=0; d<4; ++d) {
                    int nextR = fire.r + dr[d];
                    int nextC = fire.c + dc[d];
                    if (isValid(nextR, nextC) && (map[nextR][nextC] != '#' && map[nextR][nextC] != 'F')) {
                        map[nextR][nextC] = 'F';
                        fq.add(new Node(nextR, nextC));
                    }
                }
            }

            int jl = jq.size();
            for (int i=0; i<jl; ++i) {
                Node jihun = jq.poll();

                if (jihun.r == 0 || jihun.r == R-1 || jihun.c == 0 || jihun.c == C-1) {
                    return jihun.cnt+1;
                }

                for (int d=0; d<4; ++d) {
                    int nextR = jihun.r + dr[d];
                    int nextC = jihun.c + dc[d];
                    if (isValid(nextR, nextC) && (map[nextR][nextC] != '#' && map[nextR][nextC] != 'F' && map[nextR][nextC] != 'J')) {
                        map[nextR][nextC] = 'J';
                        jq.add(new Node(nextR, nextC, jihun.cnt+1));
                    }
                }
            }
        }



        return -1;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }
}
