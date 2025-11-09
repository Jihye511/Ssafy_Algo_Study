import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<ArrayList<Node>> adjList;
    public static class Node implements Comparable<Node>{
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

        //프림
        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adjList.get(v).add(new Node(u,cost));
            adjList.get(u).add(new Node(v,cost));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[N+1];
        int cost = 0;
        pq.add(new Node(1,0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            if (visited[curr.to]) continue;
            cost += curr.cost;
            visited[curr.to] = true;

            for (Node n : adjList.get(curr.to)) {
                if (!visited[n.to]) pq.add(n);
            }
        }

        System.out.println(cost);
        
    }
}
