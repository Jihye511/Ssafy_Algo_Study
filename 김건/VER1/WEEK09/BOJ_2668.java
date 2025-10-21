package Baekjoon.WEEK9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2668 {
    static int[] tailCount;
    static int[] arr;
    static boolean[] check;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n, N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        check = new boolean[N + 1];
        tailCount = new int[N+1];
        int c = 0;

        for (int i=1; i<=N; i++) {
            n = Integer.parseInt(br.readLine());
            arr[i] = n;
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
//            System.out.println("dfs"+i);
            check = new boolean[N + 1];
            max = Math.max(dfs(i, i, 1), max);
        }

//        System.out.println("Max : "+max);
//        System.out.println(Arrays.toString(tailCount));
        for (int i=1; i<=N; i++) {
            if (tailCount[i]>0) {
                c++;
                sb.append(i).append('\n');
            }
        }

        System.out.println(c);
        System.out.print(sb.toString());
    }

    static int dfs(int idx, int origin, int c) {
//        System.out.println(idx);
        if (check[idx]) return 0;
        check[idx] = true;
        if (arr[idx] == origin) {
            tailCount[idx] = c;
            return c;
        }
        int re = dfs(arr[idx], origin, c+1);
        if (re == 0) return 0;
        else {
            tailCount[idx] = Math.max(dfs(arr[idx], origin, c+1), tailCount[idx]);
            return tailCount[idx];
        }
    }
}
