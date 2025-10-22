package Baekjoon.VER2.WEEK1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];

        int s;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            s = 0;
            for (int j=0; j<M; j++) {
                s += Integer.parseInt(st.nextToken());
                arr[i][j] = s;
            }
        }
        int K = Integer.parseInt(br.readLine());
        for (int step=0; step<K; step++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken()) - 1;

            s = 0;
            for (int i = r1; i < r2; i++) {
                if (c1 > 0) {
                    s += arr[i][c2] - arr[i][c1 - 1];
                } else {
                    s += arr[i][c2];
                }
            }

            sb.append(s).append("\n");
        }

        System.out.print(sb.toString());
    }
}
