package WEEK05;

import java.io.*;
import java.util.*;

public class BOJ_1260 {

    static int N, M, V;
    static boolean[][] graph;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new boolean[N+1][N+1];

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s][e] = true;
            graph[e][s] = true;
        }

        boolean[] visited = new boolean[N+1];
        sb = new StringBuilder();
        dfs(V, visited);
        sb.append("\n");
        bfs(V);

        System.out.println(sb);
    }

    public static void dfs(int node, boolean[] visited) {
        visited[node] = true;
        sb.append(node).append(" ");
        for (int i=1; i<=N; ++i) {
            if (graph[node][i] && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        boolean[] visited = new boolean[N+1];
        visited[start] = true;

        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");

            for (int i=1; i<=N; ++i) {
                if (graph[curr][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }
}
