package 신승용.WEEK13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_22866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[N];
        int[] reverseAns = new int[N];
        int[] counts = new int[N];
        int[] reverseCnts = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = N-1; i >= 0; i--) {
            int cur = arr[i];

            while (!stack.isEmpty()) {
                if(arr[stack.peek()] > cur){
                    break;
                }
                stack.pop();
            }

            counts[i] = stack.size();

            if(stack.isEmpty()){
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(i);
        }

        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            int cur = arr[i];

            while (!stack.isEmpty()) {
                if(arr[stack.peek()] > cur){
                    break;
                }
                stack.pop();
            }

            reverseCnts[i] = stack.size();

            if(stack.isEmpty()){
                reverseAns[i] = -1;
            } else {
                reverseAns[i] = stack.peek();
            }

            stack.push(i);
        }

        for (int i = 0; i < N; i++) {
            int answer = 0;
            int count = counts[i] + reverseCnts[i];

            if(ans[i] != -1 && reverseAns[i] != -1){
                if(Math.abs(i-ans[i]) < Math.abs(i-reverseAns[i])){
                    answer = ans[i];
                } else if(Math.abs(i-ans[i]) > Math.abs(i-reverseAns[i])) {
                    answer = reverseAns[i];
                } else {
                    answer = Math.min(ans[i], reverseAns[i]);
                }
            } else {
                if(ans[i] != -1){
                    answer = ans[i];
                } else {
                    answer = reverseAns[i];
                }
            }
            if(count != 0){
                System.out.println(count + " " + (answer+1));
            } else {
                System.out.println(0);
            }
        }
    }
}
