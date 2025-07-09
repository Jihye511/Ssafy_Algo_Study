import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         int N = Integer.parseInt(st.nextToken());
         long[] d = new long[N];

         st = new StringTokenizer(br.readLine());
        for (int i = 1; i < d.length; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }

        long ans = 0;

        st = new StringTokenizer(br.readLine());
        int min_p = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            ans += d[i] * min_p;
            min_p = Math.min(Integer.parseInt(st.nextToken()), min_p);
        }

        System.out.println(ans);

    }
}