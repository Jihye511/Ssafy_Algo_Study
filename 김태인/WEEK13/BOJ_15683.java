import java.awt.*;
import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y, cctv;
        Node(int x, int y, int cctv){
            this.x = x;
            this.y = y;
            this.cctv = cctv;
        }
    }

    static int N, M, result, cctv_cnt;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static ArrayList<Node> arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        arr = new ArrayList<>();
        result = Integer.MAX_VALUE;
        int temp;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp > 0 && temp < 6) arr.add(new Node(i, j, temp));
            }
        }

        cctv_cnt = arr.size();
        dfs(0, new boolean[N][M]);
        System.out.println(result);


    }

    public static void print(boolean[][] clone_map){
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(clone_map[i]));
        }
    }

    public static void dfs(int idx, boolean[][] prev_map){
        if(idx >= arr.size()){
            int cnt = count(prev_map);
            if(cnt < result) {
                result = cnt;
//                print(clone_map);
//                System.out.println();
            }

            return;
        }




        Node now_node = arr.get(idx);
        int x = now_node.x;
        int y = now_node.y;
        switch (now_node.cctv){
            case 1 :
                for (int d = 0; d < 4; d++) {
                    boolean[][] clone_map = clone(prev_map);
                    paint_map(x, y, new int[] {d}, true, clone_map);
                    dfs(idx + 1, clone_map);
                }
                break;
            case 2:
                for(int[] dire : new int[][] {{0, 1}, {2,3}}){
                    boolean[][] clone_map = clone(prev_map);
                    paint_map(x, y, dire, true, clone_map);
                    dfs(idx + 1, clone_map);
                }
                break;
            case 3 :
                for(int[] dire : new int[][] {{0, 2}, {0,3}, {1, 2}, {1, 3}}){
                    boolean[][] clone_map = clone(prev_map);
                    paint_map(x, y, dire, true, clone_map);
                    dfs(idx + 1, clone_map);
                }
                break;

            case 4:
                for(int[] dire : new int[][] {{0, 1, 2}, {0, 1, 3}, {0, 2, 3}, {1, 2, 3}}){
                    boolean[][] clone_map = clone(prev_map);
                    paint_map(x, y, dire, true, clone_map);
                    dfs(idx + 1, clone_map);
                }
                break;

            case 5:
                boolean[][] clone_map = clone(prev_map);
                paint_map(x, y, new int[] {0, 1, 2, 3}, true, clone_map);
                dfs(idx + 1, clone_map);
                break;
        }
    }

    public static boolean[][] clone(boolean[][] prev_map){
        boolean[][] clone_map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                clone_map[i][j] = prev_map[i][j];
            }
        }

        return clone_map;
    }

    public static int count(boolean[][] clone_map){
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0 && !clone_map[i][j]) cnt++;
            }
        }

        return cnt;
    }

    public static boolean check(int x, int y){
        if(x < 0 || x >= N || y < 0 || y >= M || map[x][y] == 6) return true;
        return false;
    }

    public static void paint_map(int x, int y, int[] dire, boolean flag, boolean[][] clone_map){
        for(int d : dire){
            int nx = x;
            int ny = y;
            while (true){
                nx = nx + dx[d];
                ny = ny + dy[d];
                if(check(nx, ny)) break;
                clone_map[nx][ny] = flag;
            }
        }
    }

}
