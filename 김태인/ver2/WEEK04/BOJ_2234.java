import java.awt.*;
import java.io.*;
import java.util.*;
public class Main {

    static class Node{
        int bit;
        boolean[] path;
        Node(int bit){
            this.bit = bit;
            path = new boolean[4];
            check_path(bit, path);
        }

        public static void check_path(int bit, boolean[] path){
            for(int i = 0; i < 4; i++){
                int check_sum = (int)(Math.pow(2, i));
                if((bit & check_sum) == check_sum) path[i] = true;
            }
        }

        @Override
        public String toString() {
            return "Node{" +
                    "bit=" + bit +
                    ", path=" + Arrays.toString(path) +
                    '}';
        }
    }

    static int N, M, room_cnt, room_area, max_room_area;
    static Node[][] map;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static HashMap<Point, Integer> map_area;
    static int[][] map_area_arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new Node[N][M];

        room_area = 0;
        room_cnt = 0;
        max_room_area = 0;
        map_area = new HashMap<>();
        map_area_arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int bit = Integer.parseInt(st.nextToken());
                map[i][j] = new Node(bit);
            }
        }

        boolean[][] visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    room_cnt++;
                    bfs(i, j, visited);
                }
            }
        }

        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(!visited[i][j]){
                    bfs2(i, j, visited);
                }
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bfs3(i, j);
            }
        }


        System.out.println(room_cnt);
        System.out.println(room_area);
        System.out.println(max_room_area);

    }

    public static void bfs3(int start_x, int start_y){
        Node node = map[start_x][start_y];

        boolean[][] visited = new boolean[N][M];
        Queue<Point> q = new ArrayDeque<>();
        visited[start_x][start_y] = true;
        q.add(new Point(start_x, start_y));

        Point temp;

        while (!q.isEmpty()){
            temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!map[x][y].path[i] && check(nx, ny)){
                    if(!visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

        }


        for (int i = 0; i < 4; i++) {
            int nx = start_x + dx[i];
            int ny = start_y + dy[i];

            if(check(nx, ny) && node.path[i] && !visited[nx][ny]){
                max_room_area = Math.max(max_room_area, map_area_arr[start_x][start_y] + map_area_arr[nx][ny]);
            }

        }

    }

    public static void bfs2(int start_x, int start_y, boolean[][] visited){
        Queue<Point> q = new ArrayDeque<>();
        visited[start_x][start_y] = true;
        q.add(new Point(start_x, start_y));

        Point temp;
        int area = map_area.get(new Point(start_x, start_y));
        map_area_arr[start_x][start_y] = area;

        while (!q.isEmpty()){
            temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!map[x][y].path[i] && check(nx, ny)){
                    if(!visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                        map_area_arr[nx][ny] = area;
                    }
                }
            }

        }
    }

    public static void bfs(int start_x, int start_y, boolean[][] visited){
        Queue<Point> q = new ArrayDeque<>();
        visited[start_x][start_y] = true;
        q.add(new Point(start_x, start_y));

        Point temp;
        int area = 0;
        while (!q.isEmpty()){
            temp = q.poll();
            area++;
            int x = temp.x;
            int y = temp.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(!map[x][y].path[i] && check(nx, ny)){
                    if(!visited[nx][ny]){
                        q.add(new Point(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }

        }

        map_area.put(new Point(start_x, start_y), area);
        room_area = Math.max(area, room_area);
    }

    public static boolean check(int nx, int ny){
        return nx >= 0 && nx < N && ny >= 0 && ny < M;
    }

}
