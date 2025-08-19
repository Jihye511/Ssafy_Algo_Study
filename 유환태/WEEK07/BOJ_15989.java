package boj;

import java.util.*;
import java.io.*;

public class Main15989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[10000];

        dp[0] = 1;

        int pivot = 1;
        int six_cnt = 0;
        for(int i=1; i<10000; i++){
            dp[i] = dp[i-1] + pivot;
            six_cnt++;
            if(six_cnt==5){
                dp[i] += 1;
            }
            if(six_cnt==6){
                pivot += 1;
                six_cnt = 0;
            }
        }

        for(int i=0; i<T; i++){
            int num =  Integer.parseInt(br.readLine());
            System.out.println(dp[num-1]);
        }
    }
}
