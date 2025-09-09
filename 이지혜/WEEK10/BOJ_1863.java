import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] building = new int[n + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            building[i] = y;
        }
        building[n] = 0; // 끝까지 확인 가능

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0); 
        int result = 0;

        for (int h : building) {
            int cur = h;
            while (stack.peek() > h) {
                if (stack.peek() != cur) {
                    result++;
                    cur = stack.peek();
                }
                stack.pop();
            }
            stack.push(h);
        }

        System.out.println(result);
    }
}
