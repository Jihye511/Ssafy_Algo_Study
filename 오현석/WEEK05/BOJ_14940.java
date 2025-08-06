import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map, dist;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) { this.x = x; this.y = y; }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dist = new int[n][m];
        Point start = null;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) start = new Point(i, j);
                dist[i][j] = (map[i][j] == 0) ? 0 : -1;
            }
        }

        bfs(start);

        StringBuilder sb = new StringBuilder();
        for (int[] row : dist) {
            for (int d : row) sb.append(d).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(Point start) {
        Queue<Point> q = new ArrayDeque<>();
        q.add(start);
        dist[start.x][start.y] = 0;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (map[nx][ny] != 1 || dist[nx][ny] != -1) continue;

                dist[nx][ny] = dist[cur.x][cur.y] + 1;
                q.add(new Point(nx, ny));
            }
        }
    }
}
