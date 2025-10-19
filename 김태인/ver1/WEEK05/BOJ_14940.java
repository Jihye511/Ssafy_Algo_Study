import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y, cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static int N, M;
    static int start_x = -1;
    static int start_y = -1;
    static int[][] map, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];
        int num;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 2){
                    start_x = i;
                    start_y = j;
                }
            }
        }

        bfs();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    static void bfs(){
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(start_x, start_y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[start_x][start_y] = false;
        Node temp;
        int nx, ny;
        while (!q.isEmpty()){
            temp = q.poll();
            for (int i = 0; i < 4; i++) {
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

                if(!visited[nx][ny] && map[nx][ny] == 1){
                    q.add(new Node(nx, ny, temp.cnt + 1));
                    result[nx][ny] = temp.cnt + 1;
                    visited[nx][ny] = true;
                }


            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j] && map[i][j] == 1){
                    result[i][j] = -1;
                }
            }
        }

    }


}
