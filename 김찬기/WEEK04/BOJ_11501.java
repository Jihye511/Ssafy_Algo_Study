package WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_11501 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<T; ++t) {
            int N = Integer.parseInt(br.readLine());

            int[] prices = new int[N];
            long profit = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=0; i<N; ++i) {
                prices[i] = Integer.parseInt(st.nextToken());
            }

            int max = prices[N-1];
            for (int i=N-2; i>=0; --i) {
                if (prices[i] < max) {
                    profit += max-prices[i];
                }
                else {
                    max = prices[i];
                }
            }

            sb.append(profit).append("\n");
        }

        System.out.println(sb);
    }
}
