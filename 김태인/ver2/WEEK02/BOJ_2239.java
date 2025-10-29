import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] map = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String nums = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = nums.charAt(j) - '0';
            }
        }

        dfs(map);
    }

    public static boolean dfs(int[][] map){
        if (total_check(map)) {
            print_map(map);
            return true;
        }

        int[] pos = find_zero(map);
        int x = pos[0];
        int y = pos[1];

        if (x == -1) {
            print_map(map);
            return true;
        }

        for (int v = 1; v <= 9; v++) {
            if (is_valid(map, x, y, v)) {
                map[x][y] = v;
                if (dfs(map)) return true;
                map[x][y] = 0;
            }
        }

        return false;
    }

    public static void print_map(int[][] map){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static boolean total_check(int[][] map){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(map[i][j] == 0) return false;
            }
        }
        return true;
    }

    public static int[] find_zero(int[][] map) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == 0) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean is_valid(int[][] map, int x, int y, int val) {
        for (int j = 0; j < 9; j++) {
            if (map[x][j] == val) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][y] == val) return false;
        }

        int start_row = (x / 3) * 3;
        int start_col = (y / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[start_row + i][start_col + j] == val) return false;
            }
        }
        return true;
    }

}
