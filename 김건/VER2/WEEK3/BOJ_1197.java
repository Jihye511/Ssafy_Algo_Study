package Baekjoon.VER2.WEEK3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1197 {
    static class Edge {
        int e, w;

        Edge(int e, int w) {
            this.e = e;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int s,e,w;
        List<Edge>[] edges = new List[V];

        for (int i=0; i<V; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken())-1;
            e = Integer.parseInt(st.nextToken())-1;
            w = Integer.parseInt(st.nextToken());

            edges[s].add(new Edge(e, w));
            edges[e].add(new Edge(s, w));
        }

        boolean[] v = new boolean[V];
        int[] dists = new int[V];

        Arrays.fill(dists, Integer.MAX_VALUE);

        dists[0] = 0;

        int minIdx, minV;
        for (int step=0;step<V;step++) {
            minIdx = -1;
            minV = Integer.MAX_VALUE;
            for (int i=0; i<V; i++) {
                if (!v[i]&&minV>dists[i]) {
                    minV = dists[i];
                    minIdx = i;
                }
            }

            if (minIdx==-1) break;

            v[minIdx] = true;

            for (Edge edge: edges[minIdx]) {
                if (!v[edge.e]&&dists[edge.e]>edge.w) {
                    dists[edge.e] = edge.w;
                }
            }
        }

        int sum = 0;
        for (int i=0; i<V; i++) {
            sum+=dists[i];
        }

        System.out.println(sum);
    }
}
