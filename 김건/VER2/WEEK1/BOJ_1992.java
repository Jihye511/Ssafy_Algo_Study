package Baekjoon.VER2.WEEK1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1992 {
    static int N;
    static int[][] arr;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        String in;
        for (int i=0; i<N; i++) {
            in = br.readLine();

            for (int j=0; j<N; j++) {
                arr[i][j] = in.charAt(j)-'0';
            }
        }

        sb = new StringBuilder();

        compress(0, 0, N);

        System.out.println(sb.toString());
    }

    static boolean check(int r, int c, int n) {
        int type = arr[r][c];
        for (int i=r; i<r+n; i++) {
            for (int j=c; j<c+n; j++) {
                if (type!=arr[i][j]) return false;
            }
        }
        return true;
    }

    static void compress(int r, int c, int n) {
        if (check(r, c, n)) {
            sb.append(arr[r][c]);
        }
        else {
            int nn = n/2;
            sb.append('(');
            compress(r,c,nn);
            compress(r,c+nn,nn);
            compress(r+nn,c,nn);
            compress(r+nn,c+nn,nn);
            sb.append(')');
        }
    }
}
