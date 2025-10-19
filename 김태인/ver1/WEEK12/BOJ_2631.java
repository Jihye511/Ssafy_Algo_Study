import java.io.*;
import java.util.*;

public class Main {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                if(arr[i] < arr[j]){
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
        }

        int max_cnt = 0;
        for (int i = 0; i < N; i++) {
            max_cnt = Math.max(max_cnt, dp[i]);
        }

        System.out.println(N - max_cnt);


    }





}

