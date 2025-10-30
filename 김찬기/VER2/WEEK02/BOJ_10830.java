package VER2.WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_10830 {

    static int N;
    static long B;
    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new int[N][N];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] result = solve(B);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                sb.append(result[i][j]%1000).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] solve(long B) {
        if (B == 2) {
            return multi(matrix, matrix);
        }
        if (B == 1) {
            return matrix;
        }

        if (B % 2 == 0) {
            int[][] tmp = solve(B / 2);
            return multi(tmp, tmp);
        }
        else {
            return multi(solve(B-1), matrix);
        }
    }

    public static int[][] multi(int[][] m1, int[][] m2) {
        int[][] ret = new int[N][N];

        for (int i=0; i<N; ++i) {
            for (int j=0; j<N; ++j) {
                for (int k=0; k<N; ++k) {
                    ret[j][i] += m1[j][k] * m2[k][i];
                }
                ret[j][i] %= 1000;
            }
        }

        return ret;
    }
}
