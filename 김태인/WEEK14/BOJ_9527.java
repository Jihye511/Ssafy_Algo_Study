import java.util.*;
import java.io.*;

public class Main {

    static long A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        long a_cnt = bit_count(A-1);
        long b_cnt = bit_count(B);

        System.out.println(b_cnt - a_cnt);

    }

    public static long bit_count(long N){
        if (N == 0) return 0;
        long k = 63 - Long.numberOfLeadingZeros(N);
        long pow = 1L << k;

        long before = k * (1L << (k - 1));
        long maxbitnum = N - pow + 1;
        long remain = bit_count(N - pow);

        return before + maxbitnum + remain;
    }



}
