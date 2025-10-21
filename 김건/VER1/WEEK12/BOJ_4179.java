package Baekjoon.WEEK12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_4179 {
    static int R, C;
    static int[][] arr;
    static int ans = -1;
    static List<int[]> fire;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        fire = new LinkedList<>();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int r=-1, c=-1;
        arr = new int[R][C];

        for (int i=0; i<R; i++) {
            String in = br.readLine();
            for (int j=0; j<C; j++) {

                if (in.charAt(j)=='F') {
                    fire.add(new int[] {i, j});
                    arr[i][j] = 1;
                }
                else if (in.charAt(j)=='#') {
                    arr[i][j] = -1;
                }
                else if (in.charAt(j)=='J') {
                    r = i;
                    c = j;
                }
            }
        }

        bfsF();

        for (int i=0; i<R; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

        bfs(r, c);

        if (ans!=-1) System.out.println(ans);
        else System.out.println("IMPOSSIBLE");
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static void bfsF() {
        Queue<int[]> que = new ArrayDeque<>();

        for (int[] f: fire) {
            que.add(new int[] {f[0], f[1], 1});
            System.out.println(f[0]+" "+f[1]);
        }

        while (!que.isEmpty()) {
            int [] cur = que.poll();

            for (int d = 0; d < 4; d++) {
                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];
                int nd = cur[2] + 1;
                if (nr >= 0 && nr < R && nc >= 0 && nc < C && (arr[nr][nc] == 0 || arr[nr][nc] > nd)) {
                    que.add(new int[]{nr, nc, nd});
                    arr[nr][nc] = nd;
                }
            }
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> que = new ArrayDeque<>();

        que.add(new int[] {r, c, 1});
        boolean[][] v = new boolean[R][C];
        v[r][c] = true;

        while(!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0]==0||cur[0]==R-1||cur[1]==0||cur[1]==C-1) {
                ans = cur[2];
                break;
            }
            for (int d=0; d<4; d++) {
                int nr = cur[0]+dr[d];
                int nc = cur[1]+dc[d];
                int nd = cur[2]+1;

                if (nr>=0&&nr<R&&nc>=0&&nc<C&&!v[nr][nc]&&(nd<arr[nr][nc]||arr[nr][nc]==0)) {
                    que.add(new int[] {nr, nc, nd});
                    v[nr][nc] = true;
                }
            }
        }
    }
}
