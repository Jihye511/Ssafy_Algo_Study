import java.util.*;
import java.io.*;

public class Main {
    static int N,M,target;
    static ArrayList<Node>[] adjList;
    static ArrayList<Node>[] reverse;
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

        //단방향, 왕복 시간
        //최단거리 중 가장 긴 시간

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //학생수, 마을수
        M = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        adjList = new ArrayList[N+1];
        reverse = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            adjList[start].add(new Node(end,time));
            reverse[end].add(new Node(start, time));  //역방향 그래프 x -> i 돌아오는거
        }

        //다익스트라 2번
        int ans = -1;
        int[] go = dij(target, adjList);
        int[] back = dij(target, reverse);

        for (int i = 1; i <= N; i++) {
            ans = Math.max(ans, go[i] + back[i]);
        }
        System.out.println(ans);
    }

    public static int[] dij(int start, ArrayList<Node>[] graph) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(start,0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            for (Node n : graph[curr.to]) {
                if (dist[curr.to] + n.cost < dist[n.to]) {
                    dist[n.to] = dist[curr.to] + n.cost;
                    pq.add(new Node(n.to, dist[n.to]));
                }
            }
        }

        return dist;
    }
}
