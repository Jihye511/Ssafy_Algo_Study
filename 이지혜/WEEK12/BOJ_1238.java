import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int to, w;
        Edge(int to, int w) { 
            this.to = to; 
            this.w = w; 
        }
        
    }

    static final int INF = 1_000_000_000;

    static int N, M, X;
    static List<Edge>[] g, rg; // g: 정방향, rg: 역방향

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        g = new ArrayList[N + 1];
        rg = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            g[i] = new ArrayList<>();
            rg[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            g[s].add(new Edge(e, t));   // 정방향
            rg[e].add(new Edge(s, t));  // 역방향(뒤집어서 저장)
        }

        int[] distFromX = dijkstra(g, X);
        int[] distToX = dijkstra(rg, X);

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (i == X) continue;
            if (distToX[i] == INF || distFromX[i] == INF) continue; // 도달 불가 보호
            ans = Math.max(ans, distToX[i] + distFromX[i]);
        }
        System.out.println(ans);
    }

    static int[] dijkstra(List<Edge>[] graph, int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        boolean[] visited = new boolean[N + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0];
            int d = cur[1];

            if (visited[u]) continue;
            visited[u] = true;

            if (d > dist[u]) continue;

            for (Edge e : graph[u]) {
                int v = e.to;
                int nd = d + e.w;
                if (nd < dist[v]) {
                    dist[v] = nd;
                    pq.offer(new int[]{v, nd});
                }
            }
        }
        return dist;
    }
}
