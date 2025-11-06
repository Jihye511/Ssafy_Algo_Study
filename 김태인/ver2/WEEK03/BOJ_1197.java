import java.io.*;
import java.util.*;
public class Main {

    static class Node implements Comparable<Node>{
        int next, dist;
        Node(int next, int dist){
            this.next = next;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }

    }

    static int V, E, result;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++){
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st= new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new Node(b, c));
            adj[b].add(new Node(a, c));
        }


        result = bfs();
        System.out.println(result);

    }

    public static int bfs(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        boolean[] visited = new boolean[V+1];
        int cost = 0;
        while (!pq.isEmpty()){
            Node temp = pq.poll();
            if(visited[temp.next]) continue;
            visited[temp.next] = true;
            cost += temp.dist;
            for (Node next_node : adj[temp.next]){
                if(!visited[next_node.next]) pq.add(next_node);
            }
        }

        return cost;
    }

}
