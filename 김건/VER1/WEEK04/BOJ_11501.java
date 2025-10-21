package Baekjoon.WEEK4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for (int i=0 ; i<N; i++) {
            int M = Integer.parseInt(br.readLine());
            long benefit = 0;
            int[] costs = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j<M; j++) {
                costs[j] = Integer.parseInt(st.nextToken());
            }

            int maxCost = 0;
            for (int j = M-1; j>=0 ; j--) {
                if (maxCost < costs[j]) {
                    maxCost = costs[j];
                }
                else {
                    benefit += maxCost - costs[j];
                }
            }

            System.out.println(benefit);
        }
    }
}
