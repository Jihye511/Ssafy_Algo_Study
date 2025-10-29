import java.util.*;
import java.io.*;

public class Boj_2239_스도쿠 {
    static int[][] map;
    static List<int[]> blank;
    static boolean[][] row, col, block;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        blank = new ArrayList<>();
        row = new boolean[9][10];
        col = new boolean[9][10];
        block = new boolean[9][10];  //i번째 열에 숫자 n 있

        StringTokenizer st;
        for (int i = 0; i < 9; i++) {
            char[] m = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                map[i][j] = m[j] - '0';
                if (map[i][j] == 0) {
                    blank.add(new int[] {i,j});
                    continue;
                }

                row[i][map[i][j]-1] = true;
                col[j][map[i][j]-1] = true;
                block[i/3*3 + j/3][map[i][j]-1] = true;
            }
        }

        dfs(0);

    }

    static void dfs(int depth) {
        if (depth == blank.size()) {
            //프린트
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.print("\n");
            }
            System.exit(0);
        }

        int[] curr = blank.get(depth);
        int r = curr[0];
        int c = curr[1];
        int b = (r/3) * 3 + c/3;

        for (int n = 1; n <= 9; n++) {
            if (row[r][n-1] || col[c][n -1] || block[b][n-1]) continue;
            map[r][c] = n;
            row[r][n-1] = col[c][n-1] = block[b][n-1] = true;

            dfs(depth+1);

            map[r][c] = 0; //백트래킹
            row[r][n-1] = col[c][n-1] = block[b][n-1] = false;

        }
    }
}
