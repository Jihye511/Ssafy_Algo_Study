package boj;

import java.util.*;
import java.io.*;

public class BOJ_15683 {
    static int R, C;
    static int[][] map;
    static class Cctv{
        int r;
        int c;
        int n;
        Cctv(int r, int c, int n){
            this.r = r;
            this.c = c;
            this.n = n;
        }
    }
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static List<Cctv> cctvs = new ArrayList<>();
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]>=1 && map[i][j] <=5){
                    cctvs.add(new Cctv(i,j,map[i][j]));
                }
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    private static void dfs(int idx) {
        if(idx >= cctvs.size()){
            ans = Math.min(ans, count());
            return;
        }

        Cctv cur = cctvs.get(idx);

        List<int[]> dirSets = getDirSets(cur.n);

        for(int[] dirs : dirSets){
            List<int[]> changedAll = new ArrayList<>();
            for(int d : dirs){
                changedAll.addAll(watch(cur.r, cur.c, d));
            }
            dfs(idx+1);
            for(int i = changedAll.size()-1; i>=0; i--){
                int[] pos = changedAll.get(i);
                map[pos[0]][pos[1]] = 0;
            }
        }
    }

    private static int count() {
        int cnt = 0;
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(map[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    private static List<int[]> watch(int r, int c, int d){
        List<int[]> changed = new ArrayList<>();
        int nr = r + dr[d];
        int nc = c + dc[d];
        while(0 <= nr && nr < R && 0 <= nc && nc < C){
            if(map[nr][nc] == 6) break;
            if(map[nr][nc] == 0){
                map[nr][nc] = 7;
                changed.add(new int[]{nr, nc});
            }
            nr += dr[d];
            nc += dc[d];
        }
        return changed;
    }

    private static List<int[]> getDirSets(int n) {
        List<int[]> list = new ArrayList<>();
        switch(n){
            case 1:
                list.add(new int[]{0});
                list.add(new int[]{1});
                list.add(new int[]{2});
                list.add(new int[]{3});
                break;
            case 2:
                list.add(new int[]{0,1});
                list.add(new int[]{2,3});
                break;
            case 3:
                list.add(new int[]{0,3});
                list.add(new int[]{3,1});
                list.add(new int[]{1,2});
                list.add(new int[]{2,0});
                break;
            case 4:
                list.add(new int[]{0,2,3});
                list.add(new int[]{0,1,3});
                list.add(new int[]{1,2,3});
                list.add(new int[]{0,1,2});
                break;
            case 5:
                list.add(new int[]{0,1,2,3});
                break;
        }
        return list;
    }
}
