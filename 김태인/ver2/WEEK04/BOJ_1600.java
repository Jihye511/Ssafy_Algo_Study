import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.util.*;

public class Main {
    static class Node{
        int x, y, cnt, horse_cnt;
        public Node(int x, int y, int cnt, int horse_cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.horse_cnt = horse_cnt;
        }
    }
    static int W, H;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int[] horse_dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] horse_dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        visited = new boolean[H][W][k+1];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        int result;
        result = bfs(0, 0, 0, k);
        System.out.println(result);

    }
    private static int bfs(int start_x, int start_y, int cnt, int horse_cnt) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start_x, start_y, cnt, horse_cnt));
        Node temp;
        visited[start_x][start_y][horse_cnt] = true;
        while(!q.isEmpty()) {
            temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            cnt = temp.cnt;
            horse_cnt = temp.horse_cnt;

            if (x == H - 1 && y == W - 1) {
                return cnt;
            }

            int nx, ny;


            if(horse_cnt > 0) {
                for (int i = 0; i < 8; i++) {
                    nx = x + horse_dx[i];
                    ny = y + horse_dy[i];
                    if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                    if(visited[nx][ny][horse_cnt-1]) continue;

                    if(map[nx][ny] == 0 && !visited[nx][ny][horse_cnt]) {
                        q.add(new Node(nx, ny, cnt + 1, horse_cnt -1));
                        visited[nx][ny][horse_cnt - 1] = true;
                    }
                }
            }

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if(nx < 0 || nx >= H || ny < 0 || ny >= W) continue;

                if(map[nx][ny] == 0 && !visited[nx][ny][horse_cnt]) {
                    q.add(new Node(nx, ny, cnt + 1, horse_cnt));

                    visited[nx][ny][horse_cnt] = true;
                }
            }

        }
        return -1;

    }

}
