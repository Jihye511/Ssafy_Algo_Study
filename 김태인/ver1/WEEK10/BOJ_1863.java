import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static char[] goal_buttons;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek() > y){
                result++;
                stack.pop();
            }

            if (!stack.isEmpty() && stack.peek() == y) continue;

            stack.push(y);

        }

        while (!stack.isEmpty()){
            if(stack.peek() > 0){
                result++;
            }
            stack.pop();
        }

        System.out.println(result);
    }

}
