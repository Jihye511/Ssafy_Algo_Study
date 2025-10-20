package 신승용.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446 {

    static class Node implements Comparable<Node>{
        int v, d;
        Node(int v, int d){ this.v = v; this.d = d; }
        @Override
        public int compareTo(Node o){ return Integer.compare(this.d, o.d); }
    }

    static class Vertex implements Comparable<Vertex>{
        int e, w;
        Vertex(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Vertex o) {
            return Integer.compare(this.w, o.w);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        ArrayList<Vertex>[] adjList = new ArrayList[D+1];

        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < adjList.length; i++) {
            adjList[i].add(new Vertex(i+1, 1));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if (v < 0 || v > D || e < 0 || e > D) continue;
            if (e <= v) continue;                    
            if (w >= (e - v)) continue;
            adjList[v].add(new Vertex(e, w));
        }

        final int INF = 1_000_000_000;
        int[] dist = new int[D+1];
        Arrays.fill(dist, INF);
        dist[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if (cur.d != dist[cur.v]) continue;
            if (cur.v == D) break;

            for (Vertex nx : adjList[cur.v]){
                int nd = cur.d + nx.w;
                if (nd < dist[nx.e]){
                    dist[nx.e] = nd;
                    pq.add(new Node(nx.e, nd));
                }
            }
        }

        System.out.println(dist[D]);
        
    }
}
