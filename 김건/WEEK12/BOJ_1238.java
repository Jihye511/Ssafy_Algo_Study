package Baekjoon.WEEK12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1238 {
    static int N, M, X;
    static List<Vertex>[] adjList;
    static int[][] dists;
    static class Vertex implements Comparable<Vertex> {
        int e,w;
        Vertex(int e, int w) {
            this.e = e;
            this.w = w;
        }
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        dists = new int[N+1][N+1];
        adjList = new List[N+1];

        for (int i=1; i<=N; i++) {
            adjList[i]=new ArrayList<>();
        }

        int s, e, w;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            adjList[s].add(new Vertex(e, w));
        }

        int max = 0;
        for (int i=1; i<=N; i++) {
            dijkstra(i);
        }
        for (int i=1; i<=N; i++) {
            if (i==X) continue;
            max = Math.max(max, dists[i][X]+dists[X][i]);
        }

        System.out.println(max);
    }

    static void dijkstra(int idx) {
        PriorityQueue<Vertex> pq = new PriorityQueue<>();

        int[] dist = dists[idx];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[idx] = 0;
        pq.add(new Vertex(idx, 0));

        while(!pq.isEmpty()) {
            Vertex cur = pq.poll();

            if (dist[cur.e] < cur.w) continue;

            for (Vertex next:adjList[cur.e]) {
                if (dist[next.e]>cur.w+next.w) {
                    dist[next.e] = cur.w+next.w;
                    pq.add(new Vertex(next.e, dist[next.e]));
                }
            }
        }
    }
}
