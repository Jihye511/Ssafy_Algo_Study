package 신승용.VER2.WEEK07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BOJ_9942 {
    static final int MAX = 1000;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // T[n] : 3개 막대 하노이 최소 횟수 (2^n - 1)
        BigInteger[] three = new BigInteger[MAX + 1];
        // F[n] : 4개 막대 하노이 최소 횟수
        BigInteger[] four = new BigInteger[MAX + 1];

        // 3개 막대: T[0] = 0, T[n] = 2*T[n-1] + 1
        three[0] = BigInteger.ZERO;
        for (int i = 1; i <= MAX; i++) {
            three[i] = three[i - 1].shiftLeft(1).add(BigInteger.ONE); // 2*prev + 1
        }

        // 4개 막대: F[0] = 0
        four[0] = BigInteger.ZERO;

        for (int n = 1; n <= MAX; n++) {
            // k = 0 인 경우: 그냥 3개 막대처럼 하는 경우
            BigInteger best = three[n];

            // k = 1..n-1 인 경우들 중 최소
            for (int k = 1; k < n; k++) {
                // candidate = 2*F(k) + T(n-k)
                BigInteger cand = four[k].shiftLeft(1).add(three[n - k]);
                if (cand.compareTo(best) < 0) {
                    best = cand;
                }
            }

            four[n] = best;
        }

        String line;
        int tc = 1;
        while ((line = br.readLine()) != null && line.length() > 0) {
            int n = Integer.parseInt(line.trim());
            sb.append("Case ").append(tc++).append(": ").append(four[n]).append('\n');
        }

        System.out.print(sb);
    }
}
