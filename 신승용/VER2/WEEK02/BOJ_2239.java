package 신승용.VER2.WEEK02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2239 {
    static int[][] map = new int[9][9];
    static boolean solved = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j)+"");
            }
        }
        dfs(0, 0);
    }

    static void dfs(int r, int c) {
        if (solved) return;

        if (c == 9) {
            dfs(r + 1, 0);
            return;
        }

        if (r == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);

            solved = true;
            return;
        }

        if (map[r][c] != 0) {
            dfs(r, c + 1);
            return;
        }

        for (int num = 1; num <= 9; num++) {
            if (isValid(r, c, num)) {
                map[r][c] = num;
                dfs(r, c + 1);
                map[r][c] = 0;
            }
        }
    }

    static boolean isValid(int r, int c, int num) {
        for (int i = 0; i < 9; i++) {
            if (map[r][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (map[i][c] == num) return false;
        }

        int x = (r / 3) * 3;
        int y = (c / 3) * 3;
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (map[i][j] == num) return false;
            }
        }
        return true;
    }

}