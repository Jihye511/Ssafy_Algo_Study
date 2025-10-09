package WEEK14;

import java.io.*;
import java.util.*;

public class BOJ_1943 {

    static class Coin {
        int value;
        int cnt;

        public Coin() {}
        public Coin(int value, int cnt) {
            this.value = value;
            this.cnt = cnt;
        }
    }

    static int N;
    static List<Coin> coins;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int t=0; t<3; ++t) {
            N = Integer.parseInt(br.readLine()); // 동전 종류
            coins = new ArrayList<>();

            int sum = 0;
            for (int i = 0; i < N; ++i) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                coins.add(new Coin(v, c));
                sum += v*c;
            }

            if (sum % 2 != 0) {
                sb.append(0).append("\n");
                continue;
            }

            sum /= 2;
            boolean[][] dp = new boolean[N+1][sum+1];
            dp[0][0] = true;
            for (int i=1; i<=N; ++i) {
                Coin curr = coins.get(i-1);
                for (int j=0; j<=sum; ++j) {
                    if (dp[i-1][j]) {
                        for (int k=0; k<=curr.cnt; ++k) {
                            int total = j + curr.value * k;
                            if (total <= sum) {
                                dp[i][total] = true;
                            }
                        }
                    }
                }
            }

            if (dp[N][sum]) {
                sb.append(1).append("\n");
            }
            else {
                sb.append(0).append("\n");
            }
        }
        System.out.print(sb);
    }
}
