package WEEK08;

import java.io.*;
import java.util.*;

public class BOJ_2493 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] top = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i=0; i<N; ++i) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        int[] location = new int[N];
        stack.addLast(N-1);
        int idx = N-2;
        while (idx >= 0) {
            if (!stack.isEmpty() && top[stack.peekLast()] < top[idx]) {
                while (!stack.isEmpty() && top[stack.peekLast()] < top[idx]) {
                    location[stack.pollLast()] = idx+1;
                }
            }
            else {
                stack.addLast(idx);
                --idx;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int h : location) {
            sb.append(h).append(" ");
        }
        System.out.println(sb);
    }
}
