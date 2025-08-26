package 신승용.WEEK08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek()[1] < num) {
                stack.pop();
            }
            
            if(stack.isEmpty()){
                arr[i] = 0;
            } else{
                arr[i] = stack.peek()[0] + 1;
            }

            stack.push(new int[]{i, num});
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/**
 * 9 4 6 3 7 8
 * 9: stack 비어 있으니 삽입
 * 4: 9 > 4 이므로 삽입
 * 6: 4 < 6 이므로 4 pop, 9는 9 > 6 이므로 pass
 */