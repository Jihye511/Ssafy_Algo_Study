import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x, y, time;
        Node(int x, int y, int time){
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    static int R, C;
    static char[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] fire_map;
    static Queue<Node> fire_q = new LinkedList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        fire_map = new int[R][C];
        for (int[] row : fire_map) Arrays.fill(row, Integer.MAX_VALUE);

        String word;
        char temp;
        int start_x = 0;
        int start_y = 0;
        int fire_x = 0;
        int fire_y = 0;

        for (int i = 0; i < R; i++) {
            word = br.readLine();
            for (int j = 0; j < C; j++) {
                temp = word.charAt(j);
                map[i][j] = temp;
                if(temp == 'J'){
                    start_x = i;
                    start_y = j;
                }
                if(temp == 'F'){
                    fire_q.add(new Node(i, j, 0));
                    fire_map[i][j] = 0;
                }
            }



        }

        if (start_x == 0 || start_x == R - 1 || start_y == 0 || start_y == C - 1) {
            System.out.println(1);
            return;
        }

        fire_bfs();
        int result = bfs(start_x, start_y);

        System.out.println(result == -1 ? "IMPOSSIBLE" : result);

    }

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 0));
        boolean[][] visited = new boolean[R][C];

        Node temp;
        int nx,ny;
        while(!q.isEmpty()){
            temp = q.poll();
            for (int d = 0; d < 4; d++) {
                nx = temp.x + dx[d];
                ny = temp.y + dy[d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C) {
                    return temp.time + 1;
                }

                if (!visited[nx][ny] && map[nx][ny] == '.' && (temp.time + 1 < fire_map[nx][ny])) {
                    visited[nx][ny] = true;
                    q.add(new Node(nx, ny, temp.time + 1));
                }

            }
        }
        return -1;
    }


    public static void fire_bfs() {
        boolean[][] visited = new boolean[R][C];
        for (Node fire : fire_q) {
            visited[fire.x][fire.y] = true;
        }

        while (!fire_q.isEmpty()) {
            Node temp = fire_q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = temp.x + dx[d];
                int ny = temp.y + dy[d];

                if (nx < 0 || nx >= R || ny < 0 || ny >= C || visited[nx][ny] || map[nx][ny] == '#') continue;

                visited[nx][ny] = true;
                fire_map[nx][ny] = temp.time + 1;
                fire_q.add(new Node(nx, ny, temp.time + 1));
            }
        }
    }

}
