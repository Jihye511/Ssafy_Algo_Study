import java.util.*;
import java.io.*;

public class Main {

    static int N, S;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        dp = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp_sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            dp_sum[i] = dp_sum[i-1] + dp[i-1];
        }

        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;

        while (right <= N){
            if (dp_sum[right] - dp_sum[left] >= S){
                result = Math.min(result, right - left);
                left++;
            }
            else {
                if (right == N) break;
                right++;
            }
        }

        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
