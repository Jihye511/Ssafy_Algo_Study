import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long B;
    static int[][] map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }

        int[][] new_map = clone_map(map);
        int[][] result_map = dfs(B, new_map);
        print(result_map);
    }

    public static void print(int[][] now_map){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(now_map[i][j] % 1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] dfs(long idx, int[][] now_map){
        if(idx == 1){
            return clone_map(now_map);
        }
        int[][] temp_map = dfs(idx / 2, now_map);
        int[][] next_map = cal_map(temp_map, temp_map);
        if(idx % 2 == 0) return next_map;
        return cal_map(next_map, now_map);


    }

    public static int[][] cal_map(int[][] now_map, int[][] diff_map){
        int[][] result_map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result_map[i][j] = mul_map(now_map, diff_map, i, j) % 1000;
            }
        }
        return result_map;
    }

    public static int mul_map(int[][] now_map, int[][] diff_map, int x, int y){
        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += now_map[i][y] * diff_map[x][i];
            sum = sum % 1000;
        }

        return sum;

    }

    public static int[][] clone_map(int[][] prev_map){
        int[][] new_map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                new_map[i][j] = prev_map[i][j];
            }
        }

        return new_map;
    }

}
