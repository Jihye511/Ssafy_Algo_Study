package WEEK12;

import java.io.*;
import java.util.*;

public class BOJ_2631 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] memo = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            memo[i] = 1;
            for (int j=0; j<i; ++j) {
                if (arr[j] < arr[i]) {
                    if (memo[j]+1 > memo[i]) {
                        memo[i] = memo[j]+1;
                        max = Math.max(max, memo[i]);
                    }
                }
            }
        }

        System.out.println(N - max);
    }
}
