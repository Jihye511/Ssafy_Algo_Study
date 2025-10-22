package VER2.WEEK01;

import java.io.*;
import java.util.*;

public class BOJ_1992 {

    static int N;
    static int[][] map;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i=0; i<N; ++i) {
            String s = br.readLine();
            for (int j=0; j<N; ++j) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        check(0, 0, N);

        System.out.println(sb);
    }

    public static void check(int r, int c, int size) {
        if (size == 1) {
            sb.append(map[r][c]);
            return;
        }

        int curr = map[r][c];
        boolean isOk = true;
        K: for (int i=0; i<size; ++i) {
            for (int j=0; j<size; ++j) {
                if (map[r+i][c+j] != curr) {
                    isOk = false;
                    break K;
                }
            }
        }

        if (isOk) {
            sb.append(curr);
        }
        else {
            sb.append("(");

            int nSize = size / 2;
            check(r, c, nSize);
            check(r, c+nSize, nSize);
            check(r+nSize, c, nSize);
            check(r+nSize, c+nSize, nSize);

            sb.append(")");
        }
    }
}
