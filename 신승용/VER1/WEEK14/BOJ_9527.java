package 신승용.WEEK14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9527 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        System.out.println(countOne(B) - countOne(A-1));
    }

    static long countOne(long n) {
        if(n < 0) return 0;
        long answer = 0L;

        for (int i = 0; (1L<<i) <= n; i++) {
            long p = 1L << (i+1);
            long cycle = 1L << i;
            long full = (n+1) / p;
            long remain = (n+1) % p;
            
            answer += full*cycle + Math.max(0, remain - cycle);
        }

        return answer;
    }
}
