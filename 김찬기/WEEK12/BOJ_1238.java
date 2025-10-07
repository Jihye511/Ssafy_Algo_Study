package WEEK12;

import java.io.*;
import java.sql.Array;
import java.util.*;

public class BOJ_1238 {

    static class Edge {
        int e;
        int v;

        public Edge() {}
        public Edge(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }
    
    static int N, M, X;
    static List<List<Edge>> edges;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 도로 수
        X = Integer.parseInt(st.nextToken()); // 마을 번호 (1 ~ N)

        edges = new ArrayList<>();
        for (int i=0; i<=N; ++i) {
            edges.add(new ArrayList<>());
        }

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            edges.get(s).add(new Edge(e, v));
        }

        int max = Integer.MIN_VALUE;
        for (int i=1; i<=N; ++i) {
            max = Math.max(max, dijkstra(i, X, true));
        }

        System.out.println(max);
    }

    public static int dijkstra(int start, int end, boolean isFirst) {
        boolean[] visited = new boolean[N+1];
        Queue<Edge> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge curr = pq.poll();

            if (visited[curr.e]) {
                continue;
            }
            visited[curr.e] = true;

            if (curr.e == end) {
                if (isFirst) {
                    return curr.v + dijkstra(end, start, false);
                }
                else {
                    return curr.v;
                }
            }

            for (Edge next : edges.get(curr.e)) {
                if (!visited[next.e]) {
                    pq.add(new Edge(next.e, curr.v + next.v));
                }
            }

        }

        return 0;
    }
}
