package boj;

import java.util.*;
import java.io.*;

public class BOJ_1987 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] alpha;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];
        alpha = new int[26];
        ans = Integer.MIN_VALUE;
        for(int i=0; i<R; i++){
            String line  = br.readLine();
            for(int j=0; j<C; j++){
                map[i][j] = line.charAt(j);
            }
        }

        dfs(0,0, 1);
        System.out.println(ans);
    }

    private static void dfs(int r, int c, int cnt) {
        alpha[map[r][c] - 'A'] += 1;
        visited[r][c] = true;
        ans = Math.max(ans, cnt);
        for(int i=0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < R && nc >= 0 && nc < C){
                if(!visited[nr][nc]){
                    if(alpha[map[nr][nc] - 'A'] == 0){
                        dfs(nr, nc, cnt+1);
                    }
                }
            }
        }

        alpha[map[r][c] - 'A'] -= 1;
        visited[r][c] = false;
    }
}
