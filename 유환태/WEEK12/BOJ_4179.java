import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] fireDist, jihunDist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static final int INF = Integer.MAX_VALUE;

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r; this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        fireDist = new int[R][C];
        jihunDist = new int[R][C];

        Queue<Point> fireQ = new ArrayDeque<>();
        Point jihunStart = null;

        for (int r = 0; r < R; r++) {
            String line = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = line.charAt(c);
                fireDist[r][c] = INF;
                jihunDist[r][c] = -1;

                if (map[r][c] == 'F') {
                    fireQ.add(new Point(r, c));
                    fireDist[r][c] = 0;
                }
                if (map[r][c] == 'J') {
                    jihunStart = new Point(r, c);
                    jihunDist[r][c] = 0;
                }
            }
        }

        while (!fireQ.isEmpty()) {
            Point cur = fireQ.poll();
            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == '#' || fireDist[nr][nc] != INF) continue;
                fireDist[nr][nc] = fireDist[cur.r][cur.c] + 1;
                fireQ.add(new Point(nr, nc));
            }
        }

        Queue<Point> jihunQ = new ArrayDeque<>();
        jihunQ.add(jihunStart);

        while (!jihunQ.isEmpty()) {
            Point cur = jihunQ.poll();

            if (cur.r == 0 || cur.r == R - 1 || cur.c == 0 || cur.c == C - 1) {
                System.out.println(jihunDist[cur.r][cur.c] + 1);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nr = cur.r + dr[k];
                int nc = cur.c + dc[k];
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if (map[nr][nc] == '#' || jihunDist[nr][nc] != -1) continue;

                int nextTime = jihunDist[cur.r][cur.c] + 1;
                if (nextTime < fireDist[nr][nc]) { 
                    jihunDist[nr][nc] = nextTime;
                    jihunQ.add(new Point(nr, nc));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
