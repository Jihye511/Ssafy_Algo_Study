import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for (int tc = 0; tc < 3; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] v = new int[N];
            int[] c = new int[N];

            int sum = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                v[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
                sum += v[i] * c[i];
            }

            if ((sum & 1) == 1) { 
                System.out.println(0);
                continue;
            }

            int target = sum / 2;
            boolean[] dp = new boolean[target + 1];
            dp[0] = true;

            // 이진 분할로 bounded -> 0/1 변환
            outer:
            for (int i = 0; i < N; i++) {
                int val = v[i], cnt = c[i];
                for (int k = 1; cnt > 0; k <<= 1) {
                    int take = Math.min(k, cnt);
                    int w = val * take;

                    for (int s = target; s >= w; s--) {
                        if (!dp[s] && dp[s - w]) dp[s] = true;
                    }
                    if (dp[target]) {
                        break outer; 
                    }
                    cnt -= take;
                }
            }

            System.out.println(dp[target] ? 1 : 0);
        }
    }
}
