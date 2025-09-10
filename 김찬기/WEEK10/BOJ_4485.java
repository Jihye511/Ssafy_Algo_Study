package WEEK10;

import java.io.*;
import java.util.*;

public class BOJ_4485 {

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

    static int N;
    static int[][] map;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pr = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            map = new int[N][N];
            for (int i=0; i<N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = dijkstra();
            sb.append("Problem ").append(pr).append(": ").append(result).append("\n");
            ++pr;
        }

        System.out.println(sb);
    }

    public static int dijkstra() {
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        pq.add(new Node(0, 0, map[0][0]));
        boolean[][] visited = new boolean[N][N];

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (visited[curr.r][curr.c]) {
                continue;
            }
            visited[curr.r][curr.c] = true;

            if (curr.r == N-1 && curr.c == N-1) {
                return curr.v;
            }

            for (int d=0; d<4; ++d) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && !visited[nextR][nextC]) {
                    pq.add(new Node(nextR, nextC, curr.v + map[nextR][nextC]));
                }
            }

        }

        return 0;
    }

    public static boolean isValid(int r, int c) {
        return r>=0 && r<N && c>=0 && c<N;
    }
}
