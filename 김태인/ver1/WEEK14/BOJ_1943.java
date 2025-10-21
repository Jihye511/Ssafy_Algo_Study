import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int t = 0; t < 3; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][2];
            int total_value = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                arr[i][0] = a;
                arr[i][1] = b;
                total_value += a * b;
            }

            if (total_value % 2 == 1){
                System.out.println(0);
                continue;
            }

            int half_value = total_value / 2;

            boolean[] dp = new boolean[half_value+ 1];
            dp[0] = true;

            for (int i = 0; i < N; i++) {
                int value = arr[i][0];
                int cnt = arr[i][1];
                int[] used = new int[half_value + 1];

                for (int j = value; j <= half_value ; j++) {
                    if(!dp[j] && dp[j - value] && used[j - value] < cnt){
                        dp[j] = true;
                        used[j] = used[j - value] + 1;
                    }
                    else if (dp[j]){
                        used[j] = 0;
                    }
                }
            }

            System.out.println(dp[half_value] ? 1 : 0);


        }
    }



}
