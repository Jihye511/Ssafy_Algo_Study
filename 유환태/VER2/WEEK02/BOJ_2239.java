package boj;

import java.util.*;
import java.io.*;

public class BOJ_2239 {
    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static List<Point> zeros = new ArrayList<>();
    static int[][] sudoku;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        sudoku = new int[9][9];

        for (int r = 0; r < 9; r++) {
            String line = br.readLine();
            for (int c = 0; c < 9; c++) {
                sudoku[r][c] = line.charAt(c) - '0';
                if (sudoku[r][c] == 0) {
                    zeros.add(new Point(r, c));
                }
            }
        }

        dfs(0);

    }

    private static void dfs(int idx) {
        if (idx == zeros.size()) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 9; c++) {
                    System.out.print(sudoku[r][c]);
                }
                System.out.println();
            }
            System.exit(0);
            return;
        }
        Point p = zeros.get(idx);

        for (int j = 1; j <= 9; j++) {
            sudoku[p.r][p.c] = j;
            boolean isValid = true;
            for (int i = 0; i < 9; i++) {
                if (p.c == i) continue;

                if (sudoku[p.r][i] == j) {
                    isValid = false;
                }
            }
            for (int i = 0; i < 9; i++) {
                if (p.r == i) continue;
                if (sudoku[i][p.c] == j) {
                    isValid = false;
                }
            }

            for (int r = (p.r / 3) * 3; r < (p.r / 3) * 3 + 3; r++) {
                for (int c = (p.c / 3) * 3; c < (p.c / 3) * 3 + 3; c++) {
                    if (p.r == r && p.c == c) continue;
                    if (sudoku[r][c] == j) {
                        isValid = false;
                    }
                }
            }

            if (isValid) {
                dfs(idx + 1);
            }
            sudoku[p.r][p.c] = 0;
        }

    }
}
