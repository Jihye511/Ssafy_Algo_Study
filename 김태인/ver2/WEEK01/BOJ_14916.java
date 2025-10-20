import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        Arrays.fill(dp, 100001);

        dp[0] = 0;
        for (int i = 5; i <= N; i += 5) {
            dp[i] = Math.min(dp[i], dp[i-5] + 1);
        }

        for (int i = 2; i <= N; i++) {
            if(dp[i] >= 100001) dp[i] = Math.min(dp[i], dp[i-2] + 1);
        }

//        System.out.println(Arrays.toString(dp));

        if(dp[N] == 100001) System.out.println(-1);
        else System.out.println(dp[N]);

    }
}
