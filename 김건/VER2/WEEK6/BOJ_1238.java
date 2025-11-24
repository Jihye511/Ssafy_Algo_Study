package Baekjoon.VER2.WEEK6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1238 {
    static int N, M, X;
    static List<Edge>[] list;
    static int[][] dist;

    static class Edge implements Comparable<Edge> {
        int e, t;

        Edge(int e, int t) {
            this.e = e;
            this.t = t;
        }

        public int compareTo(Edge o) {
            return Integer.compare(this.t, o.t);
        }

        public String toString() {
            return "e: "+this.e+", t: "+this.t;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        list = new List[N+1];
        for (int i=1; i<=N; i++) {
            list[i] = new ArrayList<>();
        }
        dist = new int[N+1][N+1];
        int s, e, t;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            list[s].add(new Edge(e, t));
        }

        for (int i=1; i<=N; i++)
            dijkstra(i);

        int max=0;
        for (int i=1; i<=N; i++) {
            max = Math.max(max, dist[i][X]+dist[X][i]);
        }

        System.out.println(max);
    }

    static void dijkstra(int n) {
        PriorityQueue<Edge> que = new PriorityQueue<>();
        Arrays.fill(dist[n], 1000000);
        dist[n][n] = 0;
        que.add(new Edge(n, 0));

        while (!que.isEmpty()) {
            Edge cur = que.poll();

            if (cur.t > dist[n][cur.e]) {
                continue;
            }


            for (Edge next: list[cur.e]) {
                if (dist[n][cur.e]+next.t<dist[n][next.e]) {
                    dist[n][next.e] = dist[n][cur.e]+next.t;
                    que.add(new Edge(next.e, dist[n][next.e]));
                }
            }
        }
    }
}
