package boj;

import java.util.*;
import java.io.*;

public class BOJ_2343 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] lectures = new int[N];

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++){
            lectures[i] = Integer.parseInt(st.nextToken());
            sum += lectures[i];
            max = Math.max(max, lectures[i]);
        }

        int left = max;
        int right = sum;

        while(left <= right){
            int mid = (left + right) / 2;

            int bluelay_sum = 0;
            int bluelay_cnt = 0;

            for(int i = 0; i < N; i++){
                if(bluelay_sum + lectures[i] > mid){
                    bluelay_sum = 0;
                    bluelay_cnt++;
                }
                bluelay_sum += lectures[i];
            }

            if (bluelay_sum > 0 && bluelay_sum <= mid)
                bluelay_cnt++;

            if(bluelay_cnt <= M){
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }


        System.out.println(right + 1);
    }
}
