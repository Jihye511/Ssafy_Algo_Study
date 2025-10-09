import java.util.*;
import java.io.*;
public class Boj_9527_1의개수세기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long result = sumOnes(B) - sumOnes(A - 1);
        System.out.println(result);
    }

    static long sumOnes(long n) {
        if (n < 0) return 0;
        long ans = 0L;
        for (int k = 0; k <= 60; k++) {
            long block = 1L << (k + 1);    // 2^(k+1)
            long full  = (n + 1) / block;
            long rem   = (n + 1) % block;

            ans += full * (1L << k);

            long extra = rem - (1L << k);

            ans += Math.max(0L, extra);

        }
        return ans;
    }
}
