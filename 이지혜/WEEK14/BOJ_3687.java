import java.io.*;
import java.util.*;

public class Main {
    static final int[] cost = {6,2,5,5,4,5,6,3,7,6}; // 0~9

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String minNum = makeMin(n);
            String maxNum = makeMax(n);
            sb.append(minNum).append(' ').append(maxNum).append('\n');
        }
        System.out.print(sb);
    }

    static String makeMax(int n) {
        if (n == 2) return "1";
        if (n == 3) return "7";
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            sb.append('7');
            n -= 3;
        }
        while (n > 0) {
            sb.append('1');
            n -= 2;
        }
        return sb.toString();
    }

    static String makeMin(int n) {
        String[] dp = new String[n + 1];
        Arrays.fill(dp, null);
        dp[0] = "";

        for (int i = 1; i <= n; i++) {
            String best = null;
            for (int d = 0; d <= 9; d++) {
                int c = cost[d];
                if (i - c < 0) continue;
                String prev = dp[i - c];
                if (prev == null) continue;

                if (prev.isEmpty() && d == 0) continue;

                String cand = prev + (char)('0' + d);
                if (best == null || smaller(cand, best)) best = cand;
            }
            dp[i] = best;
        }
        return dp[n] == null ? "-1" : dp[n];
    }

    static boolean smaller(String a, String b) {
        if (a.length() != b.length()) return a.length() < b.length();
        return a.compareTo(b) < 0;
    }
}
