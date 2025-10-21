package 신승용.WEEK10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_1863 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int answer = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cx = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            while (stack.peek() > h) {
                stack.pop();
                answer++;
            }
            if (stack.peek() < h && h > 0) {
                stack.push(h);
            }
        }

        while (stack.peek() > 0) {
            stack.pop();
            answer++;
        }

        System.out.println(answer);
    }
}
