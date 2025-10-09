import java.io.*;
import java.util.*;

public class Q9527 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long ans = countOne(B) - countOne(A - 1);
        
        System.out.println(ans);
    }

    private static long countOne(long n) {
        if (n == 0) {
            return 0;
        }

        long result = 0;
        long pow = 1;

        for (int i = 0; i <= 60; i++) {
            long block = pow * 2;
            long fullBlocks = (n + 1) / block;
            long remainder = (n + 1) % block;

            result += fullBlocks * pow;

            if (remainder > pow) {
                result += (remainder - pow);
            }

            pow = pow * 2L;
        }

        return result;
    }
}
