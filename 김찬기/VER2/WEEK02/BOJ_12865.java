package VER2.WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_12865 {

    static class Item {
        int w;
        int v;

        public Item(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Item> items = new ArrayList<>();
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            items.add(new Item(w, v));
        }

        int[][] dp = new int[N+1][K+1];
        for (int w=1; w<=K; ++w) {
            for (int i=1; i<=N; ++i) {
                Item curr = items.get(i-1);
                if (curr.w <= w) {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-curr.w] + curr.v);
                }
                else {
                    dp[i][w] = dp[i-1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
