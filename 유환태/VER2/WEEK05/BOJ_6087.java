package boj;

import java.util.*;
import java.io.*;

public class BOJ_6087 {
    static int R, C;
    static char[][] map;
    static class Point implements Comparable<Point>{
        int r;
        int c;
        int cnt;
        int d;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        Point(int r, int c, int cnt, int d){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.d = d;
        }

        @Override
        public int compareTo(Point o) {
            return this.cnt - o.cnt;
        }
    }
    static int[][][] v;
    static Point[] lazers = new Point[2];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        int lazer_idx = 0;
        for(int r = 0; r < R; r++){
            String str = br.readLine();
            for(int c = 0; c < C; c++){
                map[r][c] = str.charAt(c);
                if(map[r][c]=='C'){
                    lazers[lazer_idx] = new Point(r,c);
                    lazer_idx++;
                }
            }
        }

        PriorityQueue<Point> pq = new PriorityQueue<>();
        v = new int[4][R][C];

        pq.add(new Point(lazers[0].r, lazers[0].c, 0, -1));
        for(int d = 0; d < 4; d++){
            for(int r = 0; r < R; r++){
                Arrays.fill(v[d][r],Integer.MAX_VALUE);
            }
        }

        int min = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Point cur = pq.poll();
            if(cur.r==lazers[1].r && cur.c==lazers[1].c){
                min = Math.min(min, cur.cnt);
            }

            for(int d = 0; d < 4; d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];
                int ncnt = cur.cnt;
                if(cur.d != -1 && cur.d != d){
                    if(cur.d/2==0 && d/2==1){
                        ncnt += 1;
                    }else if(cur.d/2==1 && d/2==0){
                        ncnt += 1;
                    }
                }

                if(nr >= 0 && nc >= 0 && nr < R && nc < C && v[d][nr][nc] > ncnt){
                    if(map[nr][nc] != '*'){
                        pq.add(new Point(nr, nc, ncnt, d));
                        v[d][nr][nc] = ncnt;
                    }
                }
            }

        }
        System.out.println(min);
    }
}
