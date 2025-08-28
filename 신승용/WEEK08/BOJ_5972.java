package 신승용.WEEK08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_5972 {
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
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Vertex>[] adjList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            adjList[v].add(new Vertex(e, w));
            adjList[e].add(new Vertex(v, w));
        }

        PriorityQueue<Vertex> pq = new PriorityQueue<>();
        pq.offer(new Vertex(0, 0));

        int[] dist = new int[N];
        boolean[] visited = new boolean[N];
        
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            int minV = v.e;

            if(visited[minV]) continue;
            visited[minV] = true;

            for (Vertex target : adjList[minV]) {
                if(!visited[target.e] && dist[minV] + target.w < dist[target.e]){
                    dist[target.e] = dist[minV] + target.w;
                    pq.add(new Vertex(target.e, dist[target.e]));
                }
            }
        }

        System.out.println(dist[N-1]);
    }
}
