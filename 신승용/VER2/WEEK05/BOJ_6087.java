package 신승용.VER2.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6087 {
    static int W;
    static int H;
    static char map[][];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static class Node implements Comparable<Node>{
        int x, y, dir, cost;

        Node(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new char[H][W];
        int answer = 0;

        int startX = -1;
        int startY = -1;
        int endX = -1;
        int endY = -1;

        for (int i = 0; i < H; i++) {
            String token = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = token.charAt(j);
                if(map[i][j] == 'C'){
                    if(startX == -1){
                        startX = i;
                        startY = j;
                    } else {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }
        
        answer = daijk(startX, startY, endX, endY);
        System.out.println(answer);
    }
    static int daijk(int startX, int startY, int endX, int endY) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        int[][][] dist = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        for (int i = 0; i < dx.length; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];
            if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny] != '*'){
                dist[nx][ny][i] = 0;
                pq.offer(new Node(nx, ny, i, 0));
            }
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.cost > dist[cur.x][cur.y][cur.dir]) continue;

            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nDir = i;
                int w = cur.dir == nDir ? 0 : 1;

                if(nx>=0 && nx<H && ny>=0 && ny<W && map[nx][ny] != '*'
                    && dist[nx][ny][nDir] > cur.cost + w){
                        pq.offer(new Node(nx, ny, nDir, cur.cost + w));
                        dist[nx][ny][nDir] = cur.cost + w;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < dx.length; i++){
            ans = Math.min(ans, dist[endX][endY][i]);
        } 
        return ans;
    }

}