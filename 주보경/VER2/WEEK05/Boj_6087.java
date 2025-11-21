import java.util.*;
import java.io.*;

public class Boj_6087_레이저통신 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];
        int[][][] mirror = new int[N][M][4]; //상하좌우 방향별로 갔을 때 거울수
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(mirror[i][j], Integer.MAX_VALUE);
            }
        }
        int[] start = {0,0};
        int[] end = {0,0};
        boolean find = false;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
                if (map[i][j] == 'C') {
                    if (!find) {
                        start = new int[] {i,j};
                        find = true;
                    }
                    else {
                        end = new int[] {i,j};
                    }
                }
            }
        }

        int[] dr = {-1,1,0,0};  //상 하 좌 우 -> 0,1,2,3
        int[] dc = {0,0,-1,1};

        //* : 벽
        Deque<int[]> dq = new ArrayDeque<>();
        mirror[start[0]][start[1]][0] = 0;
        mirror[start[0]][start[1]][1] = 0;
        mirror[start[0]][start[1]][2] = 0;
        mirror[start[0]][start[1]][3] = 0;

        dq.add(new int[] {start[0], start[1], 0});
        dq.add(new int[] {start[0], start[1], 1});
        dq.add(new int[] {start[0], start[1], 2});
        dq.add(new int[] {start[0], start[1], 3});

        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            int currDir = curr[2];


            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];

                if (!inRange(nr,nc,N,M)) continue;
                if (map[nr][nc] == '*') continue;

                int cost = mirror[curr[0]][curr[1]][currDir] + (currDir == i ? 0 : 1);
                if (cost < mirror[nr][nc][i]) {
                    mirror[nr][nc][i] = cost;
                    dq.add(new int[] {nr,nc,i});
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            min = Math.min(min, mirror[end[0]][end[1]][i]);
        }

        System.out.println(min);
    }

    static boolean inRange(int r, int c, int n, int m) {
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
