package 신승용.VER2.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static int N, M, X;
    static class Node implements Comparable<Node>{
        int e, w;

        Node(int e, int w) {
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

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;

        ArrayList<Node>[] adjList = new ArrayList[N];
        ArrayList<Node>[] reverse = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adjList[v].add(new Node(e, w));
            reverse[e].add(new Node(v, w));
        }

        int sum = 0;
        int[] arr = daijkstra(X, adjList);
        int[] rev_arr = daijkstra(X, reverse);

        for (int i = 0; i < arr.length; i++) {
            sum = Math.max(sum, arr[i] + rev_arr[i]);
        }

        System.out.println(sum);
    }

    static int[] daijkstra(int start, ArrayList<Node>[] adjList){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();

            for (Node next : adjList[cur.e]) {
                if(dist[next.e] >= dist[cur.e] + next.w){
                    dist[next.e] = dist[cur.e] + next.w;
                    pq.offer(new Node(next.e, dist[next.e]));
                }
            }
        }

        return dist;
    }
}
