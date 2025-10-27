package Baekjoon.VER2.WEEK2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_12865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][K+1];
        int g, w;
        st = new StringTokenizer(br.readLine());

        g = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i=g; i<=K; i++) {
            arr[0][i] = w;
        }
        for (int i=1; i<N; i++) {
            st = new StringTokenizer(br.readLine());

            g = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            for (int j=0; j<Math.min(g,K+1); j++) {
                arr[i][j] = arr[i-1][j];
            }
            for (int j=g; j<=K; j++) {
                arr[i][j] = Math.max(arr[i-1][j], w+arr[i-1][j-g]);
            }
        }

        System.out.println(arr[N-1][K]);
    }
}
