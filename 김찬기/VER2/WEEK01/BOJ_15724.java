package VER2.WEEK01;

import java.io.*;
import java.util.*;

public class BOJ_15724 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N+1][M+1];
        for (int i=1; i<=N; ++i) {
            for (int j=1; j<=M; ++j) {
                sum[i][j] = map[i-1][j-1] + sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1];
            }
        }


        int K = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (K > 0) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int total = sum[x2][y2] - sum[x2][y1-1] - sum[x1-1][y2] + sum[x1-1][y1-1];

            sb.append(total).append("\n");
            --K;
        }

        System.out.println(sb);

    }
}
