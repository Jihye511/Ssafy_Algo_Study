import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static final int MAX_N = 1000;
    static long[] pow2 = new long[63];
    static long[] dp = new long[MAX_N + 1];

    public static void main(String[] args) throws Exception {
        precompute();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String line;
        int caseNo = 1;

        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int n = Integer.parseInt(line);

            sb.append("Case ")
                    .append(caseNo++)
                    .append(": ")
                    .append(dp[n])
                    .append('\n');
        }

        System.out.print(sb);
    }

    static void precompute() {
        pow2[0] = 1L;
        for (int i = 1; i < 63; i++) {
            pow2[i] = pow2[i - 1] << 1;
        }

        dp[1] = 1L;
        for (int n = 2; n <= MAX_N; n++) {
            long best = Long.MAX_VALUE;

            for (int k = 1; k < n; k++) {
                int rem = n - k;

                if (rem >= 63) continue;

                long threePegMoves = pow2[rem] - 1;
                long candidate = 2L * dp[k] + threePegMoves;

                if (candidate < best) {
                    best = candidate;
                }
            }

            dp[n] = best;
        }
    }
}
