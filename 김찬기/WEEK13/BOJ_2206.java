package WEEK13;

import java.io.*;
import java.util.*;

public class BOJ_2206 {

    static class Node {
        int r;
        int c;
        int cnt;
        int crash;

        public Node() {}
        public Node(int r, int c, int cnt, int crash) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.crash = crash;
        }
    }

    static int N, M;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i=0; i<N; ++i) {
            String s = br.readLine();
            for (int j=0; j<M; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 1, 0));
        boolean[][][] visited = new boolean[2][N][M];

        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (curr.r == N-1 && curr.c == M-1) {
                return curr.cnt;
            }

            for (int d=0; d<4; ++d) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && !visited[curr.crash][nextR][nextC]) {
                    if (map[nextR][nextC] == 1) {
                        if (curr.crash == 0) {
                            q.add(new Node(nextR, nextC, curr.cnt+1, 1));
                            visited[1][nextR][nextC] = true;
                        }
                    }
                    else {
                        q.add(new Node(nextR, nextC, curr.cnt+1, curr.crash));
                        visited[curr.crash][nextR][nextC] = true;
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
