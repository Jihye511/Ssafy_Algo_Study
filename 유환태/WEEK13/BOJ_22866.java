package boj;

import java.util.*;
import java.io.*;

public class BOJ_22866 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        int[] buildings = new int[N];
        int[] cnt = new int[N];
        int[] close = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            buildings[i] = Integer.parseInt(st.nextToken());
            close[i] = -100000;
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < N; i++){
            while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]){
                stack.pop();
            }
            cnt[i] = stack.size();
            if(cnt[i] > 0) close[i] = stack.peek();
            stack.push(i);
        }
        stack = new Stack<>();
        for(int i = N-1; i >= 0; i--){
            while(!stack.isEmpty() && buildings[stack.peek()] <= buildings[i]){
                stack.pop();
            }
            cnt[i] += stack.size();
            if(!stack.isEmpty() && stack.peek() - i < i - close[i]) close[i] = stack.peek();
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            if(cnt[i]!=0){
                close[i] += 1;
                sb.append(cnt[i] + " " + close[i] + "\n");
            }else{
                sb.append(cnt[i] + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
