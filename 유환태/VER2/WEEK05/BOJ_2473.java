package boj;

import java.util.*;
import java.io.*;

public class BOJ_2473 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        long[] liquid = new long[N];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            liquid[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquid);
        long min = Long.MAX_VALUE;
        int left = 0;
        int right = N-1;
        long l1 = 0;
        long l2 = 0;
        long l3 = 0;
        for(int i = 0; i <= N-3; i++){
            left = i+1;
            right = N-1;

            while(left < right){
                long sum = liquid[i] + liquid[left] + liquid[right];

                if(Math.abs(sum)<min){
                    l2 = liquid[left];
                    l3 = liquid[right];
                    l1 = liquid[i];
                    min = Math.abs(sum);
                }

                if(sum < 0){
                    left++;
                }else {
                    right--;
                }
            }

        }
        System.out.println(l1 + " " + l2 + " " + l3);
    }
}
