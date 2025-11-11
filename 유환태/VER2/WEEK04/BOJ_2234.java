import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] v;
    static int[][] room;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int max_area = Integer.MIN_VALUE;
    static int area;
    static int maxarea_wall = Integer.MIN_VALUE;
    static List<Integer> room_Area;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        v = new boolean[M][N];
        room = new int[M][N];
        for(int r = 0; r < M; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        room_Area = new ArrayList<>();
        for(int r = 0; r < M; r++){
            for(int c = 0; c < N; c++){
                if(!v[r][c]){
                    area = 0;
                    cnt++;
                    v[r][c] = true;
                    dfs(r, c, cnt);
                    room_Area.add(area);
                    max_area = Math.max(max_area, area);
                }
            }
        }
//        for (int r = 0; r < M; r++){
//            for(int c = 0; c < N; c++){
//                System.out.print(room[r][c] + " ");
//
//            }
//            System.out.println();
//        }

        v = new boolean[M][N];
        dfs_wall(0,0);

        System.out.println(cnt);
        System.out.println(max_area);
        System.out.println(maxarea_wall);
    }

    private static void dfs_wall(int r, int c) {
        v[r][c] = true;

        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nc >= 0 && nr < M && nc < N && !v[nr][nc]){
                if(room[nr][nc] != room[r][c]){
                    int a = room_Area.get(room[r][c]-1);
                    int b = room_Area.get(room[nr][nc]-1);
                    maxarea_wall = Math.max(maxarea_wall, a+b);
                }
                dfs_wall(nr,nc);
            }
        }
    }

    private static void dfs(int r, int c, int idx) {
        room[r][c] = idx;
        List<Integer> walls = new ArrayList<>();

        String wall = Integer.toBinaryString(map[r][c]);
        int len = wall.length();
        for(int i = 0; i < 4 - len; i++){
            wall = "0" + wall;
        }

        for(int i = 0; i < 4; i++){
            if(wall.charAt(i)=='1'){
                walls.add(i);
            }
        }

        for(int d = 0; d < 4; d++){
            if(walls.contains(d)) continue;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if(nr >= 0 && nc >= 0 && nr < M && nc < N && !v[nr][nc]){
                v[nr][nc] = true;
                dfs(nr,nc,idx);
            }
        }
        area++;
    }
}
