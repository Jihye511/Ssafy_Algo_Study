import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); 
        int d = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 
        int c = Integer.parseInt(st.nextToken()); 

        int[] belt = new int[N];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }

        int[] cnt = new int[d + 1];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[belt[i]]++ == 0) distinct++;
        }

        int answer = distinct + (cnt[c] == 0 ? 1 : 0);

        for (int start = 1; start < N; start++) {
            int out = belt[start - 1];           
            int in  = belt[(start + k - 1) % N]; 

            if (--cnt[out] == 0) distinct--;

            if (cnt[in]++ == 0) distinct++;

            int withCoupon = distinct + (cnt[c] == 0 ? 1 : 0);
            if (withCoupon > answer) answer = withCoupon;
        }

        System.out.println(answer);
    }
}
