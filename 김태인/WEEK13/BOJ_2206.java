import java.util.*;
import java.io.*;

public class Main {
    
    static class Node{
        int x, y, dist;
        boolean wall;
        Node(int x, int y, int dist, boolean wall){
            this.x = x;
            this.y = y;
            this.dist = dist;
            this.wall = wall;

        }
    }
    
    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = temp.charAt(j) - '0';
            }
        }
        
        
        bfs();
    }
    
    public static void bfs(){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0,0, 1, false));
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        
        Node temp;
        while (!q.isEmpty()){
            temp = q.poll();
            if(temp.x == N-1 && temp.y == M-1){
                System.out.println(temp.dist);
                return;
            }
            for (int d = 0; d < 4; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(map[nx][ny] == 0){
                    if(!temp.wall && !visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.add(new Node(nx, ny, temp.dist + 1, false));
                    }
                    else if(!visited[nx][ny][1]){
                        visited[nx][ny][1] = true;
                        q.add(new Node(nx, ny, temp.dist + 1, true));
                    }
                }
                else{
                    if(!temp.wall){
                       visited[nx][ny][1] = true;
                       q.add(new Node(nx, ny, temp.dist + 1, true));
                    }
                }

            }
        }

        System.out.println(-1);
    }

}
