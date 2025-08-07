package WEEK05;

import java.io.*;
import java.util.*;

public class BOJ_14940 {

    static class Node {
        int r;
        int c;
        int v;

        public Node() {}
        public Node(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }

    static int N, M;
    static int[][] map, dist;
    static Node start;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        dist = new int[N][M];

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start = new Node(i, j, 0);
                }
                else if (map[i][j] == 1) {
                    dist[i][j] = -1;
                }
            }
        }

        find();

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void find() {

        boolean[][] visited = new boolean[N][M];
        Queue<Node> q = new ArrayDeque<>();
        q.add(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            dist[curr.r][curr.c] = curr.v;

            for (int d=0; d<4; ++d) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && map[nextR][nextC] != 0 && !visited[nextR][nextC]) {
                    visited[nextR][nextC] = true;
                    q.add(new Node(nextR, nextC, curr.v+1));
                }
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
