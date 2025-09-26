import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] dp = new int[N];
        for(int i =0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;
        for(int i =0; i<N; i++){
            dp[i] =1;
            for(int j =0; j<i; j++){
                if(arr[j]<arr[i] && dp[j]+1>dp[i]){
                    dp[i] = dp[j] +1;
                    max = Math.max(max,dp[i]);
                }
            }
        }
        System.out.println(N-max);
    }

}
