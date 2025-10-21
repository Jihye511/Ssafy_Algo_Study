package 신승용.WEEK12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static class Node implements Comparable<Node>{
        int e, w;
        
        Node(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.w, o.w);
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken())-1;

        ArrayList<Node>[] adjList = new ArrayList[N];
        ArrayList<Node>[] adjListR = new ArrayList[N];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
            adjListR[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adjList[v].add(new Node(e, w));
            adjListR[e].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        int[] distR = new int[N];
        Arrays.fill(distR, Integer.MAX_VALUE);
        distR[X] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int minV = cur.e;

            for (Node node : adjListR[minV]) {
                if(distR[minV] + node.w < distR[node.e]){
                    distR[node.e] = distR[minV] + node.w;
                    pq.add(new Node(node.e, distR[node.e]));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.offer(new Node(X, 0));
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[X] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int minV = cur.e;

            for (Node node : adjList[minV]) {
                if(dist[minV] + node.w < dist[node.e]){
                    dist[node.e] = dist[minV] + node.w;
                    pq.add(new Node(node.e, dist[node.e]));
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dist[i] + distR[i]);
        }

        System.out.println(answer);
    }

}
