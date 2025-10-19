import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int next, cow_cnt;
        Node(int next, int cow_cnt){
            this.next = next;
            this.cow_cnt = cow_cnt;
        }

        @Override
        public int compareTo(Node o){
            return this.cow_cnt - o.cow_cnt;
        }
    }
    static int N, M, result;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, C));
            adj[B].add(new Node(A, C));
        }

        result = 0;
        dijkstra();
        System.out.println(result);

    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.cow_cnt > dist[cur.next]) continue;
            for (Node next : adj[cur.next]) {
                int cost = dist[cur.next] + next.cow_cnt;
                if (cost <dist[next.next]){
                    dist[next.next] = cost;
                    pq.add(new Node(next.next, cost));
                }
            }

        }
        result = dist[N];

    }
}
