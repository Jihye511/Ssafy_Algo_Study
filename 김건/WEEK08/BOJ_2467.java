package Baekjoon.WEEK8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = N-1;
        int sum=0;
        int ans = Integer.MAX_VALUE, sA = s, eA = e;
        while (s<e) {
            sum = arr[s] + arr[e];

            if (ans > Math.abs(sum)) {
                ans = Math.abs(sum);
                sA = s;
                eA = e;
            }

            if (sum==0) break;
            else if (sum>0) e--;
            else s++;
        }

        System.out.println(arr[sA]+" "+arr[eA]);
    }
}

// 1. 가장 작은 두 값 더하기
// 2. + - 별로 나누어서 더하기

