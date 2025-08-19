import java.io.*;

public class Boj_123더하기4 {
    static int[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int MAX  = 10001;
        //1 -> 1
        //2 -> 1+1, 2
        //3 -> 1+1+1, 2+1, 3
        //4 -> 1+3, 2+2, 3
        
        dp = new int[MAX];
        dp[0] = 1;

        int[] nums = {1,2,3};

        for (int n : nums) {
            for (int i = n; i < MAX; i++) {
                dp[i] += dp[i-n];
            }
        }

//        System.out.println(Arrays.toString(dp));

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }
    }
}
