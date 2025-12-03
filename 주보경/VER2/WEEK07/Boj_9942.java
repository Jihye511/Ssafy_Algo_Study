import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Boj_9942_하노이의네탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N개 -> K개, N-K개로 나누기
        //K개 -> 옮겨두기 hanoi4(k)
        //N-K개 -> 옮기기 hanoi3(n-k)
        //k개 다시 옮기기 hanoi4(k)
        BigInteger INF = BigInteger.TEN.pow(500);
        BigInteger[] dp = new BigInteger[1001];
        Arrays.fill(dp, INF);
        dp[0] = BigInteger.ZERO;
        dp[1] = BigInteger.ONE;
        //dp[n] = 2 * dp[k] + hanoi3(n-k)

        BigInteger[] hanoi3 = new BigInteger[1001];
        hanoi3[0] = BigInteger.ZERO;
        for (int i = 1; i < 1001; i++) {
            hanoi3[i] = hanoi3[i-1].shiftLeft(1).add(BigInteger.ONE);
        }

        //i번 원판 최소 = min(0..i k개로 쪼갠 상태에서 옮길때)
        for (int i = 0; i < 1001; i++) {
            for (int k = 0; k <= i; k++) {
                BigInteger temp = dp[k].multiply(BigInteger.valueOf(2))
                        .add(hanoi3[i - k]);
                dp[i] = dp[i].min(temp);
            }
        }

        StringBuilder sb = new StringBuilder();
        String input;
        int idx = 1;
        while((input=br.readLine())!=null){
            int n = Integer.parseInt(input);
            sb.append("Case ").append(idx++).append(": ").append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
