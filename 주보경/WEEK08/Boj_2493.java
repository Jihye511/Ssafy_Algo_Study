import java.util.*;
import java.io.*;

public class Boj_2493_탑 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<int[]> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                stack.add(new int[] {i,curr});
                sb.append(0).append(" ");
                continue;
            }

            //스택의 현재 top 확인
            while (true) {
                if (stack.isEmpty()) {
                    sb.append(0).append(" ");
                    break;
                }
                if (stack.peek()[1] > curr) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                //pop 해야됨
                stack.pop();
            }
            stack.add(new int[] {i,curr});
        }

        System.out.println(sb);

    }
}
