package Baekjoon.WEEK10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum=0, s=0, e=0, minL=Integer.MAX_VALUE;

        while (e<N) {
            if (sum<S) {
                sum+=arr[e];
                e++;
            }
            else {
                sum-=arr[s];
                s++;
            }
            if (sum>=S) {
                minL = Math.min(minL, e-s);
            }
        }

        while (s<N) {
            if (sum>=S) {
                minL = Math.min(minL, e-s);
            }
            sum-=arr[s];
            s++;
        }

        if (minL==Integer.MAX_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(minL);
        }
    }
}