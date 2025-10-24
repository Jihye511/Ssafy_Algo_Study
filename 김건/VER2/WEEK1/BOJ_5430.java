package Baekjoon.VER2.WEEK1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BOJ_5430 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        String cmd, in;
        int N, p, size, idx;
        int[] arr;
        char c;
        boolean d;
        L:for (int t=0; t<T; t++) {
            cmd = br.readLine();
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            in = br.readLine();
            size = in.length()-1;
            p=1;
            d = true;
            idx = 0;
            if (N!=0) {
            while (p<size) {
                c = in.charAt(p++);
                if (c==',') {
                    deque.add(Integer.parseInt(sb.toString()));
                    sb.setLength(0);
                }
                else {
                    sb.append(c);
                }
            }

            deque.add(Integer.parseInt(sb.toString()));
            sb.setLength(0);
            }

            for (int i=0; i<cmd.length(); i++) {
                if (cmd.charAt(i)=='R') {
                    d=!d;
                }
                else {
                    if (deque.isEmpty()) {
                        System.out.println("error");
                        continue L;
                    }
                    if (d) deque.pollFirst();
                    else deque.pollLast();
                }
            }

            sb.append('[');
            if (!deque.isEmpty()) {
                while (!deque.isEmpty()) {
                    if (d) {
                        sb.append(deque.pollFirst());
                        sb.append(',');
                    } else {
                        sb.append(deque.pollLast());
                        sb.append(',');
                    }
                }
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(']');

            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}
