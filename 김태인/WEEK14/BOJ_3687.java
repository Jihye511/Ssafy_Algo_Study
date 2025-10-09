import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long[] dp;
    static int [] arr= {1,7,4,2,0,8};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp = new long[101];

        Arrays.fill(dp, Long.MAX_VALUE);

        dp[2]=1;
        dp[3]=7;
        dp[4]=4;
        dp[5]=2;
        dp[6]=6;
        dp[7]=8;
        dp[8]=10;

        for (int i = 9; i <= 100 ; i++) {
            for (int j = 2; j <= 7 ; j++) {
                String temp = String.valueOf(dp[i-j])+String.valueOf(arr[j-2]);
                dp[i] = Math.min(Long.parseLong(temp), dp[i]);
            }
        }

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            sb.append(dp[N]).append(" ");
            if(N%2==0){
                sb.append(changemax(N/2));
            }
            else{
                sb.append("7").append(changemax((N-3)/2));
            }

            System.out.println(sb);
        }



    }

    public static String changemax(int n){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            sb.append("1");
        }
        return sb.toString();
    }

}
