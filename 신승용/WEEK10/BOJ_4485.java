package 신승용.WEEK10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_4485 {
    static class Node implements Comparable<Node>{
        int x, y, val;
        Node (int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.val, o.val);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        while (true) {
            int N = Integer.parseInt(br.readLine());

            if (N==0) {
                break;
            }
    
            int[][] map = new int[N][N];
    
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
    
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(0, 0, map[0][0]));
            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = map[0][0];
    
            int[] dx = {-1,1,0,0};
            int[] dy = {0,0,-1,1};
    
            while (!pq.isEmpty()) {
                Node cur = pq.poll();
                int cx = cur.x;
                int cy = cur.y;
                int val = cur.val;
                
                for (int i = 0; i < dx.length; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];
                    if(nx>=0 && nx<N && ny>=0 && ny<N &&
                    dist[nx][ny] > dist[cx][cy] + map[nx][ny]){
                        dist[nx][ny] = dist[cx][cy] + map[nx][ny];
                        pq.offer(new Node(nx, ny, val+map[nx][ny]));
                    }
                }
            }
    
            System.out.println("Problem "+ tc++ + ": " + dist[N-1][N-1]);
        }
    }
}
