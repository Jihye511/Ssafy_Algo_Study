package WEEK09;

import java.io.*;
import java.util.*;

public class BOJ_2668 {

    static int[] arr;
    static boolean[] visited;
    static Queue<Integer> pq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        visited = new boolean[N+1];
        pq = new PriorityQueue<>();

        for (int i=1; i<=N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i=1; i<=N; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, i, new ArrayList<>());
                visited[i] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(pq.size()).append("\n");
        while (!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }

        System.out.println(sb);
    }

    public static boolean dfs(int idx, int start, List<Integer> list) {
        list.add(idx);
        int next = arr[idx];

        if (!visited[next]) {
            visited[next] = true;
            visited[next] = dfs(next, start, list);
        }
        else if (next == start) {
            for (int i : list) {
                pq.add(i);
            }
            return true;
        }

        return false;
    }
}
