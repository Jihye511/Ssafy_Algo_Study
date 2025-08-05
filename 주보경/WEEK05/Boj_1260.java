import java.util.*;
import java.io.*;

public class Boj_1260_DFS와BFS {
    static int N;
    static StringBuilder sb;
    static List[] adjList;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];

        for (int i = 0; i < N+1; i++) {
            adjList[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjList[v].add(u);
            adjList[u].add(v);
        }

        for (int i = 0; i < N+1; i++) {
            Collections.sort(adjList[i]);
        }

        sb = new StringBuilder();
        visited = new boolean[N+1];
        dfs(start);
        System.out.println(sb);

        visited = new boolean[N+1];
        sb.setLength(0);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(start);

        while (!dq.isEmpty()) {
            int v = dq.poll();
            if (!visited[v]) {
                visited[v] = true;
                sb.append(v + " ");
                for (int u : (ArrayList<Integer>) adjList[v]) {
                    if (!visited[u]) {
                        dq.add(u);
                    }
                }
            }
        }

        System.out.println(sb);


    }

    static void dfs(int v) {

        sb.append(v + " ");
        visited[v] = true;

        for (int u : (ArrayList<Integer>) adjList[v]) {
            if (!visited[u])
                dfs(u);
        }
    }
}
