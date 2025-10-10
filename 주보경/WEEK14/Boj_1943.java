import java.util.*;
import java.io.*;

public class Boj_1943_동전분배 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder result = new StringBuilder();

        for (int t = 0; t < 3; t++) {

            int N = Integer.parseInt(br.readLine());

            int[] value = new int[N];
            int[] count = new int[N];
            int total = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                value[i] = Integer.parseInt(st.nextToken());
                count[i] = Integer.parseInt(st.nextToken());
                total += value[i] * count[i];
            }

            // 홀수
            if ((total % 2) == 1) {
                result.append(0).append('\n');
                continue;
            }

            int target = total / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            for (int i = 0; i < N; i++) {
                int v = value[i];
                int c = count[i];

                int k = 1;
                while (c > 0) {
                    int take = Math.min(k, c);
                    int w = v * take;

                    for (int s = target; s >= w; s--) {
                        if (!dp[s] && dp[s - w]) dp[s] = true;
                    }

                    c -= take;
                    k *= 2;
                }
            }

            result.append(dp[target] ? 1 : 0).append('\n');
        }

        System.out.print(result);
    }
}
