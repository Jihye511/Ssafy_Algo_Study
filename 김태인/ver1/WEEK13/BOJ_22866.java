import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static int[] visible;
    static int[] near;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visible = new int[N];
        near = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            near[i] = -1;
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                visible[i] += stack.size();
                int dist = i - stack.peek();
                if (near[i] == -1 || dist < Math.abs(i - (near[i]-1))) {
                    near[i] = stack.peek() + 1;
                }
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = N-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                visible[i] += stack.size();
                int dist = stack.peek() - i;
                if (near[i] == -1 || dist < Math.abs(i - (near[i]-1))) {
                    near[i] = stack.peek() + 1;
                } else if (dist == Math.abs(i - (near[i]-1))) {
                    near[i] = Math.min(near[i], stack.peek() + 1);
                }
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (visible[i] == 0) sb.append(0).append("\n");
            else sb.append(visible[i]).append(" ").append(near[i]).append("\n");
        }
        System.out.print(sb);
    }
}
