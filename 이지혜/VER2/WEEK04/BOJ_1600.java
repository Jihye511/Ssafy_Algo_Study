import java.io.*;
import java.util.*;
public class Main {
    static int k, n, m;
    static int[][] map;
    static boolean[][][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    //말처럼 움직일 수 있는 좌표
    static int[] horseX = {-2, -2, -1, 1, 2, 2, -1, 1};
    static int[] horseY = {-1, 1, 2, 2, -1, 1, -2, -2};

    static int min = Integer.MAX_VALUE;

    static class Point {
        int x;
        int y;
        int horseCnt;
        int moveCnt;

        public Point(int x, int y, int horseCnt, int moveCnt) {
            this.x = x;
            this.y = y;
            this.horseCnt = horseCnt;
            this.moveCnt = moveCnt;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visit = new boolean[n][m][31];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(new Point(0, 0, 0, 0));
        System.out.println(min);
    }

    private static void bfs(Point point) {
        Queue<Point> qu = new LinkedList<>();
        qu.offer(point);
        visit[point.x][point.y][point.horseCnt] = true;

        while (!qu.isEmpty()) {
            Point p = qu.poll();

            if (p.x == n - 1 && p.y == m - 1) {
                min = Math.min(min, p.moveCnt);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                if (map[nx][ny] == 1 || visit[nx][ny][p.horseCnt]) {
                    continue;
                }
                if (map[nx][ny] == 0) {
                    visit[nx][ny][p.horseCnt] = true;
                    qu.offer(new Point(nx, ny, p.horseCnt, p.moveCnt + 1));
                }
            }

            //말처럼 움직일 수 있는 횟수가 남아있는 경우
            if (p.horseCnt < k) {
                for (int i = 0; i < 8; i++) {
                    int hx = p.x + horseX[i];
                    int hy = p.y + horseY[i];

                    if (hx < 0 || hy < 0 || hx >= n || hy >= m) {
                        continue;
                    }

                    if (map[hx][hy] == 1 || visit[hx][hy][p.horseCnt + 1]) {
                        continue;
                    }

                    if (map[hx][hy] == 0) {
                        visit[hx][hy][p.horseCnt + 1] = true;
                        qu.offer(new Point(hx, hy, p.horseCnt + 1, p.moveCnt + 1));
                    }
                }
            }
        }
        min = -1;
    }

}
