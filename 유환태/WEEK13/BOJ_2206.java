package boj;

import java.util.*;
import java.io.*;

public class BOJ_2206 {
    static int N, M;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static class Player implements Comparable<Player>{
        int r;
        int c;
        int cnt;
        int wall;
        Player(int r, int c, int cnt, int wall){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
            this.wall = wall;
        }

        @Override
        public int compareTo(Player o) {
            return this.cnt - o.cnt;
        }
    }
    static boolean[][][] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        v = new boolean[N][M][2];
        for(int i=0;i<N;i++){
            String line = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        PriorityQueue<Player> pq = new PriorityQueue<>();

        pq.add(new Player(0,0,0,0));
        v[0][0][0] = true;
        int ans = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Player cur = pq.poll();

            if(cur.r==N-1 && cur.c==M-1){
                ans = Math.min(ans, cur.cnt);
                break;
            }

            for(int d=0;d<4;d++){
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if(nr>=0&&nc>=0&&nr<N&&nc<M){
                    if(map[nr][nc]==1){
                        if(cur.wall==0){
                            if(!v[nr][nc][1]){
                                v[nr][nc][1] = true;
                                pq.add(new Player(nr,nc,cur.cnt+1,1));
                            }
                        }
                    }else{
                        if(!v[nr][nc][cur.wall]){
                            v[nr][nc][cur.wall] = true;
                            pq.add(new Player(nr,nc,cur.cnt+1,cur.wall));
                        }
                    }
                }
            }
        }
        System.out.println(ans==Integer.MAX_VALUE?-1:ans+1);
    }
}
