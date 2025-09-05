package WEEK09;

import java.io.*;
import java.util.*;

public class BOJ_16234 {

    static int N, L, R;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static List<List<Node>> list;

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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            int cnt = 0;
            visited = new boolean[N][N];
            list = new ArrayList<>();

            boolean isMoved = false;

            for (int i=0; i<N; ++i) {
                for (int j=0; j<N; ++j) {
                    if (!visited[i][j]) {
                        list.add(new ArrayList<>());
                        isMoved = bfs(i, j, cnt) || isMoved;
                        ++cnt;
                    }
                }
            }

            if (!isMoved) {
                break;
            }

            ++days;
        }

        System.out.println(days);

    }

    public static boolean bfs(int r, int c, int idx) {
        Queue<Node> q = new ArrayDeque<>();
        Node start = new Node(r, c, arr[r][c]);
        q.add(start);
        visited[r][c] = true;
        list.get(idx).add(start);
        int sum = arr[r][c];

        boolean isMoved = false;

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (int d=0; d<4; ++d) {
                int nextR = curr.r + dr[d];
                int nextC = curr.c + dc[d];

                if (isValid(nextR, nextC) && !visited[nextR][nextC] && isPossible(curr.v, arr[nextR][nextC])) {
                    Node next = new Node(nextR, nextC, arr[nextR][nextC]);
                    q.add(next);
                    list.get(idx).add(next);
                    sum += arr[nextR][nextC];
                    visited[nextR][nextC] = true;
                    isMoved = true;
                }
            }
        }

        int length = list.get(idx).size();

        for (Node node : list.get(idx)) {
            arr[node.r][node.c] = sum / length;
        }


        return isMoved;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    public static boolean isPossible(int cv, int nv) {
        int gap = Math.abs(cv-nv);
        return L <= gap && gap <= R;
    }
}
