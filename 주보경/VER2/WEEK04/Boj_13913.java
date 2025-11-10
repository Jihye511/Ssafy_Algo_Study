import java.util.*;
import java.io.*;

public class Boj_13913 {
    static int size = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[] arr = new int[size];
        int[] parent = new int[size];
        Arrays.fill(arr, -1);
        Arrays.fill(parent, -1);
        arr[start] = 0;

        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(start);

        //bfs
        //x-1, x+1, x * 2
        List<Integer> nxt;
        while (!dq.isEmpty()) {
            int curr = dq.pollFirst();
            if (curr == target) {
                break;
            }

            nxt = List.of(curr - 1, curr + 1, curr * 2);
            for (int n : nxt) {
                if (inRange(n) && arr[n] == -1) {
                    arr[n] = arr[curr] + 1;
                    parent[n] = curr;
                    dq.add(n);
                }
            }
        }

        System.out.println(arr[target]);
        Stack<Integer> stack = new Stack<>();
        //경로 복원
        int curr = target;
        while (curr != -1) {
            stack.add(curr);
            curr = parent[curr];
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    static boolean inRange(int curr) {
        return curr >= 0 && curr < size;
    }
}
