import java.util.*;
import java.io.*;

public class Boj_5972_택배 {

    public static class Node implements Comparable<Node> {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Node n) {
            return this.cost - n.cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Node>[] adjList = new ArrayList[N+1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<Node>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int src = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList[src].add(new Node(dest,cost));
            adjList[dest].add(new Node(src,cost));
        }

        int[] cost = new int[N+1];
        Arrays.fill(cost, Integer.MAX_VALUE);

        boolean[] visited = new boolean[N+1];
        cost[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1,0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node n : adjList[curr.to]) {
                if (visited[n.to]) continue;
                if (cost[n.to] > cost[curr.to] + n.cost) {
                    cost[n.to] = cost[curr.to] + n.cost;
                    pq.add(new Node(n.to, cost[n.to]));
                }
            }
            visited[curr.to] = true;
        }

        System.out.println(cost[N]);
    }
}
