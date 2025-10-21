package 신승용.WEEK14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1943 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 3;

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());
            int[][] coins = new int[N][2];
            int sum = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                coins[i][0] = Integer.parseInt(st.nextToken());
                coins[i][1] = Integer.parseInt(st.nextToken());

                sum += coins[i][0] * coins[i][1];
            }

            if(sum % 2 != 0){
                System.out.println(0);
                continue;
            }

            int goal = sum / 2;
            boolean[] dp = new boolean[goal+1];
            dp[0] = true;

            for (int i = 0; i < N; i++) {
                int amount = coins[i][0];
                int count = coins[i][1];

                int k = 1;
                while (count > 0) {
                    int group = Math.min(count, k);
                    int cost = amount * group;

                    for (int w = goal; w >= cost; w--) {
                        if(dp[w-cost]) dp[w] = true;
                    }

                    count -= group;
                    k = k*2;
                }
            }

            System.out.println(dp[goal] ? 1 : 0);
        }
    }
}
