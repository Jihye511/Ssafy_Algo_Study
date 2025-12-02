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

        BigInteger[] three = new BigInteger[MAX + 1];
        BigInteger[] four = new BigInteger[MAX + 1];

        three[0] = BigInteger.ZERO;
        for (int i = 1; i <= MAX; i++) {
            three[i] = three[i - 1].shiftLeft(1).add(BigInteger.ONE);
        }

        four[0] = BigInteger.ZERO;

        for (int n = 1; n <= MAX; n++) {
            BigInteger best = three[n];

            for (int k = 1; k < n; k++) {
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
