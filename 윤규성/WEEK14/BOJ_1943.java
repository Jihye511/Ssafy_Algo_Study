import java.io.*;
import java.util.*;

public class Q1943 {

    static class Coin {
        int value, count;
        Coin(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());
            List<Coin> coins = new ArrayList<>();
            int total = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int value = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                coins.add(new Coin(value, count));
                total += value * count;
            }

            if (total % 2 != 0) {
                sb.append(0).append("\n");
                continue;
            }

            int target = total / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            boolean possible = false;

            for (Coin coin : coins) {
                int v = coin.value;
                int c = coin.count;

                int k = 1;
                while (c > 0) {
                    int take = Math.min(k, c);
                    int weight = v * take;

                    for (int s = target; s >= weight; s--) {
                        if (!dp[s] && dp[s - weight]) {
                            dp[s] = true;
                        }
                    }

                    if (dp[target]) {
                        possible = true;
                        break;
                    }

                    c -= take;
                    k = k * 2;
                }

                if (possible) break;
            }

            if (dp[target]) {
                sb.append("1\n");
            } else {
                sb.append("0\n");
            }
        }

        System.out.print(sb.toString());
    }
}