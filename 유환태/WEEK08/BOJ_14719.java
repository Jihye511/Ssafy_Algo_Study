package boj;

import java.util.*;
import java.io.*;

public class BOJ_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;


        st =  new StringTokenizer(br.readLine());

        int H =  Integer.parseInt(st.nextToken());
        int W =  Integer.parseInt(st.nextToken());
        int[] block = new int[W];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < W; i++){
            block[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int pivot = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (Integer h : block) {
            if(stack.isEmpty()&&h>0) {
                pivot = h;
                stack.add(h);
            }else {
                if(pivot>h) {
                    stack.add(h);
                }
                else {
                    while(!stack.isEmpty()) {
                        int cur = stack.pop();
                        sum += (pivot - cur);
                    }
                    pivot = h;
                    stack.add(h);
                }
            }
        }
        Deque<Integer> stack2 = new ArrayDeque<>();
        pivot = 0;
        while(!stack.isEmpty()) {
            int h = stack.pollLast();
            if(stack2.isEmpty()&&h>0) {
                pivot = h;
                stack2.add(h);
            }else {
                if(pivot>h) {
                    stack2.add(h);
                }
                else {
                    while(!stack2.isEmpty()) {
                        int cur = stack2.pop();
                        sum += (pivot - cur);
                    }
                    pivot = h;
                    stack2.add(h);
                }
            }
        }
        System.out.println(sum);



    }
}
