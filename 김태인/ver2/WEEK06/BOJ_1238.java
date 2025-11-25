import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int next, time;
        Node(int next, int time){
            this.next = next;
            this.time = time;
        }

        @Override
        public int compareTo(Node o){
            return this.time - o.time;
        }
    }


    static int N, M, X;
    static ArrayList<Node>[] adj;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            adj[A].add(new Node(B, T));
        }

        int[] fromX = dijk(X);
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if(i == X) continue;
            int[] toX = dijk(i);
            int compare = fromX[i] + toX[X];
            result = Math.max(result, compare);
        }

        System.out.println(result);
    }

    public static int[] dijk(int start){
        int[] time = new int[N+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(now.time > time[now.next]) continue;

            for(Node next : adj[now.next]){
                if(time[next.next] > time[now.next] + next.time){
                    time[next.next] = time[now.next] + next.time;
                    pq.add(new Node(next.next, next.time));
                }
            }
        }


        return time;
    }

}
