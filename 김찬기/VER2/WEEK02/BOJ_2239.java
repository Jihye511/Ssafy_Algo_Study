package VER2.WEEK02;

import java.io.*;
import java.util.*;

import static java.lang.System.exit;

public class BOJ_2239 {

    static int zero;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        zero = 0;
        map = new int[9][9];
        for (int i=0; i<map.length; ++i) {
            String s = br.readLine();
            for (int j=0; j<map[i].length; ++j) {
                map[i][j] = s.charAt(j) - '0';
                if (map[i][j] == 0) {
                    ++zero;
                }
            }
        }

        solve(0, 0);
    }

    public static void solve(int r, int c) {

        if (zero == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i=0; i<9; ++i) {
                for (int j=0; j<9; ++j) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            exit(0);
        }


        for (int i=r; i<9; ++i) {
            for (int j=c; j<9; ++j) {
                if (map[i][j] == 0) {
                    boolean isPossible = false;
                    for (int k=1; k<10; ++k) {
                        if (check(i, j, k)) {
                            isPossible = true;
                            map[i][j] = k;
                            --zero;
                            solve(i, j);
                            isPossible = false;
                            map[i][j] = 0;
                            ++zero;
                        }
                    }
                    if (!isPossible) {
                        return;
                    }
                }
            }
            c = 0;
        }

    }

    public static boolean check(int r, int c, int num) {
        return checkR(r, num) && checkC(c, num) && checkSquare(r, c, num);
    }

    public static boolean checkR(int r, int num) {
        for (int c=0; c<9; ++c) {
            if (map[r][c] == num) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkC(int c, int num) {
        for (int r=0; r<9; ++r) {
            if (map[r][c] == num) {
                return false;
            }
        }

        return true;
    }

    public static boolean checkSquare(int r, int c, int num) {
        int nr = r - r%3;
        int nc = c - c%3;

        for (int i=0; i<3; ++i) {
            for (int j=0; j<3; ++j) {
                if (map[nr+i][nc+j] == num) {
                    return false;
                }
            }
        }


        return true;
    }
}
