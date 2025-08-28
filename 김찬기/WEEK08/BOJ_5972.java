package WEEK08;

import java.io.*;
import java.util.*;

public class BOJ_5972 {

    static int N, M;
    static List<List<Node>> graph;

    static class Node {
        int e;
        int v;

        public Node() {}
        public Node(int e, int v) {
            this.e = e;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList<>();
        for (int i=0; i<=N; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(s).add(new Node(e, v));
            graph.get(e).add(new Node(s, v));
        }

        dijkstra();
    }

    public static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.v, o2.v));
        pq.add(new Node(1, 0));
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.e == N) {
                System.out.println(dist[curr.e]);
                return;
            }

            for (Node next : graph.get(curr.e)) {
                if (dist[next.e] > dist[curr.e] + next.v) {
                    dist[next.e] = dist[curr.e] + next.v;
                    pq.add(new Node(next.e, dist[next.e]));
                }
            }
        }
    }
}
