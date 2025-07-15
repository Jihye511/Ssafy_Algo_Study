package boj;

import java.util.*;
import java.io.*;

public class BOJ_21921 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());


        int[] visitors = new int[N];
        int[] sum_visitors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            visitors[i] = Integer.parseInt(st.nextToken());
            if(i==0){
                sum_visitors[i] = visitors[i];
            }else{
                sum_visitors[i] = sum_visitors[i-1] + visitors[i];
            }
        }
        int max_visitor = sum_visitors[X-1];
        int max_count = 1;

        for (int i = X; i < N; i++) {
            int sum = sum_visitors[i] - sum_visitors[i-X];
            if(max_visitor<sum){
                max_visitor = sum;
                max_count = 1;
            }else if(max_visitor==sum){
                max_count++;
            }
        }

        if(max_visitor==0){
            System.out.println("SAD");
        }else{
            System.out.println(max_visitor);
            System.out.println(max_count);
        }
    }
}
