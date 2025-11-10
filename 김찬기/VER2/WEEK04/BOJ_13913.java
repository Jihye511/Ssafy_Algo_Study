package VER2.WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_13913 {

    static int N, K;
    static int[] times, prev;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        times = new int[100001];
        prev = new int[100001];

        times[N] = 1;
        prev[N] = -1;
        solve();

        System.out.println(times[K]-1);
        Deque<Integer> stack = new ArrayDeque<>();
        while (K != -1) {
            stack.push(K);
            K = prev[K];
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }

    public static void solve() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        while (!q.isEmpty()) {
            int curr = q.poll();

            int idx = curr - 1;
            if (isValid(idx)) {
                times[idx] = times[curr] + 1;
                prev[idx] = curr;
                q.add(idx);
            }

            if (idx > K) {
                continue;
            }

            idx = curr + 1;
            if (isValid(idx)) {
                times[idx] = times[curr] + 1;
                prev[idx] = curr;
                q.add(idx);
            }

            idx = curr * 2;
            if (isValid(idx)) {
                times[idx] = times[curr] + 1;
                prev[idx] = curr;
                q.add(idx);
            }

        }

    }

    public static boolean isValid(int idx) {
        return idx >= 0 && idx <= 100000 && times[idx] == 0;
    }
}
