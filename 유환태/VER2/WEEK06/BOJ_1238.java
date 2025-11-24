package boj;

import org.w3c.dom.Node;

import java.util.*;
import java.io.*;

public class BOJ_1238 {
    static class Node implements Comparable<Node>{
        int next;
        int weight;
        Node(int n, int w){
            this.next = n;
            this.weight = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Node>[] graph = new ArrayList[N];

        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;
            int w = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e,w));
        }

        int ans = Integer.MIN_VALUE;

        for(int s = 0; s < N; s++){
            int time = 0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(s,0));
            int[] dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[s] = 0;
            boolean[] v = new boolean[N];
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(v[cur.next]) continue;
                v[cur.next] = true;
                if(cur.next==X-1){
                    break;
                }
                for(Node next : graph[cur.next]){
                    int newW = next.weight + dist[cur.next];
                    if(dist[next.next]>newW){
                        dist[next.next] = newW;
                        pq.add(new Node(next.next, newW));
                    }
                }
            }
            time += dist[X-1];
            pq = new PriorityQueue<>();
            pq.add(new Node(X-1,0));
            dist = new int[N];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[X-1] = 0;
            v = new boolean[N];
            while(!pq.isEmpty()){
                Node cur = pq.poll();
                if(v[cur.next]) continue;
                v[cur.next] = true;
                if(cur.next==s){
                    break;
                }
                for(Node next : graph[cur.next]){
                    int newW = next.weight + dist[cur.next];
                    if(dist[next.next]>newW){
                        dist[next.next] = newW;
                        pq.add(new Node(next.next, newW));
                    }
                }
            }
            time += dist[s];
            ans = Math.max(ans, time);

        }
        System.out.println(ans);
    }
}
