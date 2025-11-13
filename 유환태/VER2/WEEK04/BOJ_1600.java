package boj;

import java.util.*;
import java.io.*;

public class BOJ_1600 {
    static int K, R, C;
    static int[][] map;
    static boolean[][][] v;
    static class Monkey{
        int r;
        int c;
        int k;
        int cnt;
        Monkey(int r, int c, int k, int cnt){
            this.r = r;
            this.c = c;
            this.k = k;
            this.cnt = cnt;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[] hr = {-1,-2,-2,-1,1,2,2,1};
    static int[] hc = {-2,-1,1,2,-2,-1,1,2};
    static Queue<Monkey> q = new ArrayDeque<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        K = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        v = new boolean[R][C][K+1];
        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Monkey(0,0,0, 0));
        int ans = -1;
        while(!q.isEmpty()){
            Monkey cur = q.poll();
            if(cur.r==R-1&&cur.c==C-1){
                ans = cur.cnt;
                break;
            }

            if(cur.k < K){
                for(int d = 0; d < 8; d++){
                    int nr = cur.r + hr[d];
                    int nc = cur.c + hc[d];
                    if(isValid(nr,nc) && map[nr][nc] == 0 && !v[nr][nc][cur.k+1]){
                        v[nr][nc][cur.k+1] = true;
                        q.add(new Monkey(nr, nc, cur.k+1, cur.cnt+1));
                    }
                }
            }

            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(isValid(nr,nc) && map[nr][nc] == 0 && !v[nr][nc][cur.k]){
                    v[nr][nc][cur.k] = true;
                    q.add(new Monkey(nr, nc, cur.k, cur.cnt+1));
                }
            }
        }
        System.out.println(ans);

    }

    private static boolean isValid(int nr, int nc) {
        return nr >= 0 && nc >= 0 && nr < R && nc < C;
    }
}
