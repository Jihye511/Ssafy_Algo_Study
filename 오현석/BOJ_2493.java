import java.io.*;
import java.util.*;

public class BOJ_2493 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        int[] ans = new int[N];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek() + 1;

            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int v : ans) sb.append(v).append(' ');
        System.out.println(sb);
    }
}
