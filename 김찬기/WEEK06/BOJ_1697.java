package WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_1697 {

    static int N, K;
    static int[] times;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        times = new int[100001];

        times[N] = 1;
        bfs();

        System.out.println(times[K] - 1);
    }

    public static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);

        while (!q.isEmpty()) {
            int curr = q.poll();

            if (curr == K) {
                return;
            }

            int idx = curr-1;
            if (isValid(idx)) {
                times[idx] = times[curr]+1;
                q.add(idx);
            }

            idx = curr+1;
            if (isValid(idx)) {
                times[idx] = times[curr]+1;
                q.add(idx);
            }

            idx = curr*2;
            if (isValid(idx)) {
                times[idx] = times[curr]+1;
                q.add(idx);
            }
        }
    }

    public static boolean isValid(int idx) {
        return idx >= 0 && idx <= 100000 && times[idx] == 0;
    }
}
