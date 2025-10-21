package 신승용.WEEK14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_3687 {

    static int[] matches = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] dp = new String[101];

        dp[2] = "1";
        dp[3] = "7";
        dp[4] = "4";
        dp[5] = "2";
        dp[6] = "6";
        dp[7] = "8";
        dp[8] = "10";

        for (int i = 9; i <= 100; i++) {
            String val = null;
            for (int d = 0; d <= 9; d++) {
                int n = matches[d];
                if(i-n<2 || dp[i-n] == null) continue;
                String c = dp[i-n] + d;
                if(val == null || c.length() < val.length()
                || (c.length() == val.length() && c.compareTo(val) < 0)){
                    val = c;
                }
            }
            dp[i] = val;
        }

        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            String min = dp[N];

            String max;
            if(N%2==0){
                max = "1".repeat(N/2);
            } else {
                max = "7" + "1".repeat((N-3) / 2);
            }

            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }
}
