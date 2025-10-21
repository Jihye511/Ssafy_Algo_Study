package Baekjoon.WEEK8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_5972 {
    static class Vertex implements Comparable<Vertex>{
        int e, w;

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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Vertex>[] adjList = new LinkedList[N+1];
        for (int i=1; i<=N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[s].add(new Vertex(e, w));
            adjList[e].add(new Vertex(s,w));
        }

        int s=1;
        PriorityQueue<Vertex> que = new PriorityQueue<>();
        int[] dist = new int[N+1];
        boolean[] v = new boolean[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        que.add(new Vertex(s, 0));

        while(!que.isEmpty()) {
            Vertex cur = que.poll();
            if (v[cur.e]) continue;
            v[cur.e] = true;

            if (cur.e==N) break;

            for (Vertex vertex : adjList[cur.e]) {
                if (!v[vertex.e]&&dist[vertex.e]>cur.w+vertex.w) {
                    dist[vertex.e] = cur.w+vertex.w;
                    que.add(new Vertex(vertex.e, dist[vertex.e]));
                }
            }
        }

        System.out.println(dist[N]);
    }
}
