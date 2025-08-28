package boj;

import java.util.*;
import java.io.*;


public class BOJ_5972 {
    static class Node implements Comparable<Node>{
        int s;
        int d;
        Node(int s, int d){
            this.s=s;
            this.d=d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Node>[] graph = new ArrayList[N];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s =  Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int d =  Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e,d));
            graph[e].add(new Node(s,d));
        }

        boolean[] v = new boolean[N];
        int[] dist = new int[N];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(0,0));
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int minV = cur.s;
            if(v[minV]) continue;
            v[minV] = true;

            for(Node next : graph[minV]){
                if(!v[next.s]&&dist[minV]+next.d < dist[next.s]){
                    dist[next.s] = dist[minV]+next.d;
                    pq.add(new Node(next.s,dist[next.s]));
                }
            }
        }

        System.out.println(dist[N-1]);
    }
}
