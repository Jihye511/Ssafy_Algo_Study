import java.io.*;
import java.util.*;

public class Boj_3687_성냥개비 {
    static final int MAX_N = 100;
    static final int[] cost = {6,2,5,5,4,5,6,3,7,6}; // 0~9 성냥개비 개수
    static String[] minDP = new String[MAX_N + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        Arrays.fill(minDP, null);

        minDP[2] = "1";
        minDP[3] = "7";
        minDP[4] = "4";
        minDP[5] = "2";
        minDP[6] = "6";
        minDP[7] = "8";

        for (int n = 8; n <= MAX_N; n++) {
            String best = null;
            for (int d = 0; d <= 9; d++) {
                int c = cost[d];
                String prev = minDP[n - c];
                if (prev == null) continue;

                String cand = prev + (char)('0' + d);

                if (best == null || isSmaller(cand, best)) {
                    best = cand;
                }
            }

            minDP[n] = best;
        }

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String mini = minDP[n];
            String maxi = buildMax(n);

            out.append(mini).append(' ').append(maxi).append('\n');
        }
        System.out.print(out);
    }

    static boolean isSmaller(String a, String b) {
        if (a.length() != b.length()) return a.length() < b.length();
        return a.compareTo(b) < 0;
    }

    static String buildMax(int n) {
        StringBuilder sb = new StringBuilder();
        if (n % 2 == 1) {
            sb.append('7');
            n -= 3;
        }
        for (int i = 0; i < n / 2; i++) sb.append('1');
        return sb.toString();
    }
}

