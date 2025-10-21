import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node>{
        int now, time;
        Node(int now, int time){
            this.now = now;
            this.time = time;
        }

        public int compareTo(Node o){
            return this.time - o.time;
        }
    }
    static int N, K;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int result = bfs();

        System.out.println(result);

    }

    public static int bfs(){
        ArrayDeque<Node> pq = new ArrayDeque<>();
        pq.add(new Node(N, 0));

        boolean[] visited = new boolean[100001];
        visited[N] = true;

        Node temp;
        while(!pq.isEmpty()){
            temp = pq.poll();
            if(temp.now == K){
                return temp.time;
            }

            if(temp.now + 1 <= 100000 && !visited[temp.now + 1]){
                pq.add(new Node(temp.now + 1, temp.time + 1));
                visited[temp.now + 1] = true;
            }

            if(temp.now - 1 >= 0 && !visited[temp.now - 1]){
                pq.add(new Node(temp.now - 1, temp.time + 1));
                visited[temp.now - 1] = true;
            }

            if(temp.now * 2 <= 100000 && !visited[temp.now * 2]){
                pq.add(new Node(temp.now * 2, temp.time + 1));
                visited[temp.now * 2] = true;
            }



        }

        return 0;
    }


}
