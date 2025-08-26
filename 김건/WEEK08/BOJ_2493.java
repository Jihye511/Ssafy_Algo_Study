package Baekjoon.WEEK8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int []> s = new Stack<>();
        L:for (int i=1; i<=N;i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!s.isEmpty()) {
                int[] cur = s.pop();

                if (cur[0] > n) {
                    sb.append(cur[1]).append(' ');
                    s.push(cur);
                    break;
                }
            }
            if (s.isEmpty()) sb.append(0).append(' ');
            s.push(new int[]{n, i});
        }

        System.out.println(sb.toString());
    }
}