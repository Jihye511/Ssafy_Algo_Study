package VER2.WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_1197 {

    static class Edge {
        int s;
        int e;
        int v;

        public Edge(int s, int e, int v) {
            this.s = s;
            this.e = e;
            this.v = v;
        }
    }

    static List<Edge> edges;
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        edges = new ArrayList<>();
        for (int i=0; i<E; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            edges.add(new Edge(s, e, v));
        }

        init();
        Collections.sort(edges, (o1, o2) -> Integer.compare(o1.v, o2.v));
        int result = 0;
        for (int i=0; i<E; ++i) {
            Edge curr = edges.get(i);
            if (!union(curr.s, curr.e)) {
                continue;
            }

            result += curr.v;
        }

        System.out.println(result);
    }

    public static void init() {
        for (int i=1; i<parent.length; ++i) {
            parent[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return false;
        }

        if (pa > pb) {
            parent[pb] = pa;
        }
        else {
            parent[pa] = pb;
        }

        return true;
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

}
