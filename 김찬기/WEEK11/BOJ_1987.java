package WEEK11;

import java.io.*;
import java.util.*;

public class BOJ_1987 {

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[] alpha = new boolean[26];
    static char[][] map;
    static int R, C, max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        map = new char[R][C];
        for (int i=0; i<R; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        alpha[map[0][0]-'A'] = true;
        dfs(0, 0, 1);

        System.out.println(max);
    }

    public static void dfs(int r, int c, int cnt) {
        int idx = map[r][c] - 'A';

        max = Math.max(max, cnt);

        for (int d=0; d<4; ++d) {
            int nextR = r + dr[d];
            int nextC = c + dc[d];
            if (isValid(nextR, nextC) && !alpha[map[nextR][nextC] - 'A']) {
                alpha[map[nextR][nextC] - 'A'] = true;
                dfs(nextR, nextC, cnt+1);
                alpha[map[nextR][nextC] - 'A'] = false;
            }
        }
    }

    public static boolean isValid(int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[r].length;
    }
}
