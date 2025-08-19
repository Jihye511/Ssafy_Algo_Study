import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int idx, time;
        public Node(int idx, int time){
            this.idx = idx;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.println(bfs(N,K));
    }
    public static int bfs(int N, int K){
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        boolean[] visited = new boolean[100001];
        pq.offer(new Node(N,0));
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            visited[cur.idx] = true;
            if(cur.idx == K) return cur.time;

            if(cur.idx >0) {
                if(!visited[cur.idx-1]){
                    pq.offer(new Node(cur.idx-1,cur.time +1));
                }

            }
            if(cur.idx <100000){
                if(!visited[cur.idx+1]) {
                    pq.offer(new Node(cur.idx + 1, cur.time + 1));
                }
            }
            if(cur.idx *2 <100001){
                if(!visited[cur.idx*2]) {
                    pq.offer(new Node(cur.idx * 2, cur.time));
                }
            }
        }
        return 0;
    }
}
