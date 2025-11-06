import java.io.*;
import java.util.*;

public class Main {
    static int V, E;
    static Edge[] edges;
    static int[] parent, rank;

    static class Edge {
        int a, b, w;
        Edge(int a, int b, int w) { this.a = a; this.b = b; this.w = w; }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int x, int y) {
        x = find(x); y = find(y);
        if (x == y) return false;
        if (rank[x] < rank[y]) parent[x] = y;
        else if (rank[x] > rank[y]) parent[y] = x;
        else { parent[y] = x; rank[x]++; }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b, w);
        }

        Arrays.sort(edges, (e1, e2) -> e1.w - e2.w);

        parent = new int[V + 1];
        rank = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        long ans = 0;
        int taken = 0;

        for (Edge e : edges) {
            if (union(e.a, e.b)) {
                ans += e.w;
                if (++taken == V - 1) break;
            }
        }

        System.out.println(ans);
    }
}
