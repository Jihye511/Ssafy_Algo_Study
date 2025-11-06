package 신승용.VER2.WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        ArrayList<Edge>[] adjList = new ArrayList[V];
        for (int i = 0; i < V; i++) adjList[i] = new ArrayList<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken());

            adjList[s].add(new Edge(e, w));
            adjList[e].add(new Edge(s, w));
        }

        boolean[] visited = new boolean[V];
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.offer(new Edge(0, 0));

        long total = 0;
        int count = 0;

        while (!pq.isEmpty() && count < V) {
            Edge cur = pq.poll();
            if (visited[cur.to]) continue;

            visited[cur.to] = true;
            count++;
            total += cur.weight;

            for (Edge next : adjList[cur.to]) {
                if (!visited[next.to] && next.weight < dist[next.to]) {
                    dist[next.to] = next.weight;
                    pq.offer(new Edge(next.to, next.weight));
                }
            }
        }

        System.out.println(total);
    }
}