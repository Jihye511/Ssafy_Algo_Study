package boj;

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class BOJ_9942 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger[] dp = new BigInteger[1001];

        dp[1] = new BigInteger("1");

        for(int i = 2; i < 1001; i++){
            long a = Math.round(Math.sqrt(2 * i + 1));
            int k = Math.toIntExact(i - a + 1);

            dp[i] = dp[k].multiply(new BigInteger("2")).add(BigInteger.valueOf((long) (Math.pow(2, i - k) - 1)));
        }

        StringBuilder sb = new StringBuilder();
        String input;
        int idx = 1;
        while((input=br.readLine())!=null && input.length()!=0){
            int n = Integer.parseInt(input);
            sb.append("Case ").append(idx++).append(": ").append(dp[n]).append("\n");
        }
        System.out.println(sb);
    }
}
