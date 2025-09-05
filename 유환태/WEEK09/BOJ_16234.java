package boj;

import java.util.*;
import java.io.*;

public class BOJ_16234 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] v;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int sum = 0;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];


        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int ans = 0;

        while(true){
            v = new boolean[N][N];
            int mcount = 0;
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!v[i][j]){
                        sum = 0;
                        list = new ArrayList<>();
                        dfs(i,j);
                        mcount++;
                        for(int[] point: list){
                            map[point[0]][point[1]]= sum/list.size();
                        }
                    }
                }
            }
            if(mcount==N*N){
                break;
            }
            ans++;
        }
        System.out.println(ans);

    }

    private static void dfs(int r, int c) {
        v[r][c] = true;
        sum += map[r][c];
        list.add(new int[] {r, c});
        for(int i=0; i<4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < N && nc >= 0 && nc < N){
                if(!v[nr][nc] && Math.abs(map[r][c] - map[nr][nc])>=L && Math.abs(map[r][c] - map[nr][nc]) <= R){
                    dfs(nr, nc);
                }
            }
        }
    }
}
