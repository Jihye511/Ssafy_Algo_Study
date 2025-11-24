package VER2.WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_1238 {

    static class Edge {
        int e;
        int t;

        public Edge(int e, int t) {
            this.e = e;
            this.t = t;
        }
    }

    static int N, M, X;
    static List<List<Edge>> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        for (int i=0; i<=N; ++i) {
            edges.add(new ArrayList<>());
        }
        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            edges.get(s).add(new Edge(e, t));
        }

        int max = 0;
        for (int i=1; i<=N; ++i) {
            if (i == X) {
                continue;
            }

            max = Math.max(max, dijkstra(i, X));
        }

        System.out.println(max);
    }

    public static int dijkstra(int s, int e) {
        boolean[] visited = new boolean[N+1];

        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));
        pq.add(new Edge(s, 0));

        int min = 0;

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.e]) {
                continue;
            }

            visited[curr.e] = true;

            if (curr.e == e) {
                min = curr.t;
                break;
            }

            for (Edge next : edges.get(curr.e)) {
                if (!visited[next.e]) {
                    pq.add(new Edge(next.e, curr.t + next.t));
                }
            }
        }

        visited = new boolean[N+1];
        pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.t, o2.t));
        pq.add(new Edge(e, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.e]) {
                continue;
            }

            visited[curr.e] = true;

            if (curr.e == s) {
                min += curr.t;
                break;
            }

            for (Edge next : edges.get(curr.e)) {
                if (!visited[next.e]) {
                    pq.add(new Edge(next.e, curr.t + next.t));
                }
            }
        }

        return min;
    }
}
