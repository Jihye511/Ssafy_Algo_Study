package boj;

import java.util.*;
import java.io.*;

public class BOJ_2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] liquid = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(liquid);

        int left = 0;
        int right = N-1;
        int min = Integer.MAX_VALUE;

        int l1 = 0;
        int l2 = 0;

        while(left<right){
            int sum =  liquid[left] + liquid[right];
            if(Math.abs(sum)<min){
                min = Math.abs(sum);
                l1 = liquid[left];
                l2 = liquid[right];
            }
            if(sum<0){
                left++;
            }else if(sum>0){
                right--;
            }else{
                l1 = liquid[left];
                l2 = liquid[right];
                break;
            }

        }

        System.out.println(l1 + " " + l2);
    }
}
