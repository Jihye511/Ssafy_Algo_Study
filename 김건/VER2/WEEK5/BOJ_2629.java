package Baekjoon.VER2.WEEK5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2629 {
    static int N, M;
    static int[] arr;
    static boolean[] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i =0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total+=arr[i];
        }
        dp = new boolean[total+1];
        dp[0] = true;

        LinkedList<Integer> list = new LinkedList<>();
        int tmp = 0;
        for (int i=0; i<N; i++) {
            tmp+=arr[i];
            for (int j=0; j<=tmp-arr[i]; j++) {
                if (dp[j]) list.add(j+arr[i]);
            }
            for (int n:list) {
                dp[n] = true;
            }
        }

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());;

        StringBuilder sb = new StringBuilder();

        for (int j=0; j<=total-n; j++) {
            if (dp[j]&&dp[j+n]) {
                sb.append('Y');
                break;
            }
        }

        if (sb.isEmpty()) {
            sb.append('N');
        }

        L:for (int i=1; i<M; i++) {
            n = Integer.parseInt(st.nextToken());
            if (n>total) {
                sb.append(' ').append('N');
                continue;
            }
            for (int j=0; j<=total-n; j++) {
                if (dp[j]&&dp[j+n]) {
                    sb.append(' ').append('Y');
                    continue L;
                }
            }
            sb.append(' ').append('N');
        }

        System.out.println(sb);
    }
}
