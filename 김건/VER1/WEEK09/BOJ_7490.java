package Baekjoon.WEEK9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7490 {
    static int[] arr = new int[10];
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            N = Integer.parseInt(br.readLine());

            dfs(2, sb);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }

    static void dfs(int idx, StringBuilder sb) {
        if (idx > N) {
            int ret = 0;
            int sum = 1;
            for (int i=2;i<=N;i++) {
                if (arr[i]==0) {
                    if (sum>0)
                        sum = sum*10 + i;
                    else {
                        sum = sum*10 - i;
                    }
                }
                else {
                    ret+=sum;
                    sum=arr[i]*i;
                }
            }
            ret+=sum;

            if (ret == 0) {
                sb.append(1);
                for (int i = 2; i <= N; i++) {
                    if (arr[i]==0) sb.append(' ').append(i);
                    else if (arr[i]==1) sb.append('+').append(i);
                    else sb.append('-').append(i);
                }
                sb.append('\n');
            }
            return;
        }
        arr[idx] = 0;
        dfs(idx+1, sb);
        arr[idx] = 1;
        dfs(idx+1, sb);
        arr[idx] = -1;
        dfs(idx+1, sb);
    }
}
