import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int next, dist;
        Node(int next, int dist){
            this.next = next;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return Integer.compare(this.dist, o.dist);
        }
    }

    static int N, M, X;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int a, b, t;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            adj[a].add(new Node(b, t));
        }

        int[] fromX = dijkstra(X);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            int[] toX = dijkstra(i);
            int temp = fromX[i] + toX[X];
            result = Math.max(temp, result);
        }

        System.out.println(result);


    }

    public static int[] dijkstra(int start){
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        Node now;
        while (!pq.isEmpty()){
            now = pq.poll();
            if(now.dist > dist[now.next]) continue;
            for (Node next : adj[now.next]){
                if(dist[next.next] > dist[now.next] + next.dist){
                    dist[next.next] = dist[now.next] + next.dist;
                    pq.add(new Node(next.next, dist[next.next]));
                }
            }
        }
        return dist;
    }

}
