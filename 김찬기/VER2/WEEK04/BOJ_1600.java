package VER2.WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_1600 {

    static class Node {
        int r;
        int c;
        int k;
        int cnt;

        public Node(int r, int c, int k, int cnt) {
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
    }

    static int K, W, H;
    static int[][] map;
    static int[] mr = {0, 1, 0, -1};
    static int[] mc = {1, 0, -1, 0};
    static int[] hr = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] hc = {-2, -1, 1, 2, 2, 1, -1, -2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        for (int i=0; i<H; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<W; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    public static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 0));
        boolean[][][] visited = new boolean[K+1][H][W];


        while (!q.isEmpty()) {
            Node curr = q.poll();

            if (visited[curr.k][curr.r][curr.c]) {
                continue;
            }

            if (curr.r == H-1 && curr.c == W-1) {
                return curr.cnt;
            }

            visited[curr.k][curr.r][curr.c] = true;

            for (int m=0; m<4; ++m) {
                int nr = curr.r + mr[m];
                int nc = curr.c + mc[m];
                if (isValid(nr, nc) && map[nr][nc] != 1 && !visited[curr.k][nr][nc]) {
                    q.add(new Node(nr, nc, curr.k, curr.cnt+1));
                }
            }

            if (curr.k < K) {
                for (int h=0; h<8; ++h) {
                    int nr = curr.r + hr[h];
                    int nc = curr.c + hc[h];
                    if (isValid(nr, nc) && map[nr][nc] != 1 && !visited[curr.k+1][nr][nc]) {
                        q.add(new Node(nr, nc, curr.k+1, curr.cnt+1));
                    }
                }
            }
        }

        return -1;
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < H && c >= 0 && c < W;
    }
}
