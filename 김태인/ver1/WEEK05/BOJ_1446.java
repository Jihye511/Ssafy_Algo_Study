import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int end, dist;
        Node(int end, int dist){
            this.end = end;
            this.dist = dist;
        }

        public int compareTo(Node o){
            return this.dist - o.dist;
        }

    }

    static int N, D, result_dist;
    static ArrayList<Node>[] adj;
    static int[] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        adj = new ArrayList[D+1];
        for(int i = 0; i <= D; i++){
            adj[i] = new ArrayList<>();

        }

        for (int i = 0; i < D; i++) {
            adj[i].add(new Node(i+1, 1));
        }



        int start, end, cost;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());
            if(end - start <= cost ) continue;
            if(end > D) continue;

            adj[start].add(new Node(end, cost));
        }
        result_dist = D;


        dist = new int[D+1];
        Arrays.fill(dist, 10001);
        dijkstra();
        System.out.println(dist[D]);



    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0] = 0;
        pq.add(new Node(0,0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if (dist[cur.end] < cur.dist) continue;
            for (Node next : adj[cur.end]) {
                if (dist[next.end] > dist[cur.end] + next.dist) {
                    dist[next.end] = dist[cur.end] + next.dist;
                    pq.offer(new Node(next.end, dist[next.end]));
                }
            }
        }
    }

}
