package VER2.WEEK04;

import java.io.*;
import java.util.*;

/**
 * 서: 1 = 왼 = 0
 * 북: 2 = 위 = 1
 * 동: 4 = 오 = 2
 * 남: 8 = 아 = 3
 */

public class BOJ_2234 {

    static class Node {
        int r;
        int c;
        int crash;

        public Node(int r, int c, int crash) {
            this.r = r;
            this.c = c;
            this.crash = crash;
        }
    }

    static int N, M;
    static int[] wall = {1, 2, 4, 8};
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static int[] max;
    static int[][] castle, idMap;
    static boolean[][][] visited;
    static List<Integer> sizeList;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        max = new int[2];
        castle = new int[N][M];
        idMap = new int[N][M];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; ++j) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        sizeList = new ArrayList<>();
        visited = new boolean[2][N][M];
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (!visited[0][i][j]) {
                    bfs(i, j, cnt);
                    ++cnt;
                }
            }
        }

        for (int i=0; i<N; ++i) {
            for (int j=0; j<M; ++j) {
                int curr = idMap[i][j];
                for (int d=0; d<4; ++d) {
                    int r = i+dr[d];
                    int c = j+dc[d];
                    if (isValid(r, c)) {
                        int next = idMap[r][c];
                        if (curr != next) {
                            max[1] = Math.max(max[1], sizeList.get(curr) + sizeList.get(next));
                        }
                    }
                }
            }
        }

        System.out.println(cnt);
        System.out.println(max[0]);
        System.out.println(max[1]);

    }

    public static void bfs(int sr, int sc, int num) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(sr, sc, 0));

        int size = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (visited[curr.crash][curr.r][curr.c]) {
                continue;
            }
            visited[curr.crash][curr.r][curr.c] = true;
            idMap[curr.r][curr.c] = num;

            ++size;

            for (int d = 0; d < 4; ++d) {
                if ((castle[curr.r][curr.c] & wall[d]) == 0) {
                    int nextR = curr.r + dr[d];
                    int nextC = curr.c + dc[d];
                    if (isValid(nextR, nextC) && !visited[curr.crash][nextR][nextC]) {
                        q.add(new Node(nextR, nextC, curr.crash));
                    }
                }
            }
        }

        sizeList.add(size);
        max[0] = Math.max(max[0], size);
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
