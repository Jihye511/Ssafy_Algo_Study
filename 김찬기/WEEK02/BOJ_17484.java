package WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_17484 {

    static int[] dc = {-1, 0, 1};
    static int[][] map;
    static int N, M, result;

    static class Node {
        int r;
        int c;
        int value;
        int prev;

        Node() {}
        Node(int r, int c, int value, int prev) {
            this.r = r;
            this.c = c;
            this.value = value;
            this.prev = prev;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = Integer.MAX_VALUE;

        map = new int[N][M];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        System.out.println(result);
    }

    public static void bfs() {
        Queue<Node> q = new ArrayDeque<>();
        int dr = 1;

        for (int i=0; i<M; ++i) {
            q.add(new Node(0, i, map[0][i], -1));
        }

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d=0; d<3; ++d) {
                if (curr.prev != d) {
                    int nextR = curr.r + dr;
                    int nextC = curr.c + dc[d];

                    if (isValid(nextR, nextC)) {
                        int nextV = curr.value + map[nextR][nextC];
                        q.add(new Node(nextR, nextC, nextV, d));
                    }
                    else if (nextR >= N) {
                        result = Math.min(result, curr.value);
                    }
                }
            }

        }


    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
