package WEEK09;

import java.io.*;
import java.util.*;

public class BOJ_22251 {

    static int[][] change = {
        {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
        {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
        {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
        {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
        {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
        {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
        {2, 6, 3, 3, 4 ,1, 0, 5, 1, 2},
        {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
        {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
        {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
        };

        static int N, K, P, X, result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 층의 수
        K = Integer.parseInt(st.nextToken()); // 자릿수
        P = Integer.parseInt(st.nextToken()); // 반전 수
        X = Integer.parseInt(st.nextToken()); // 현재 층

        result = 0;

        recursive(0, 1, 0, P);

        System.out.println(result);
    }

    public static void recursive(int x, int pow, int idx, int p) {
        if (p < 0 || x > N || idx > K) {
            return;
        }

        if (idx == K) {
            if (x > 0 && x != X) {
                ++result;
            }
            return;
        }

        for (int i=0; i<10; ++i) {
            recursive(x + i*pow, pow*10, idx+1, p-change[X/pow%10][i]);
        }
    }
}
