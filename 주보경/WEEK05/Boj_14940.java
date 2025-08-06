import java.util.*;
import java.io.*;

public class Main {
    static int N,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        int[] start = new int[2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(start);

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,1,-1};

        int[][] dist = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i],-1);
        }

        dist[start[0]][start[1]] = 0;
        while (!dq.isEmpty()) {
            int[] next = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = next[0] + dr[i];
                int nc = next[1] + dc[i];

                if (inRange(nr,nc) && map[nr][nc] != 0 && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[next[0]][next[1]] + 1;
                    dq.add(new int[] {nr,nc});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && dist[i][j] == -1)
                    sb.append(0 + " ");
                else if (map[i][j] != 0 && dist[i][j] == -1)
                    sb.append(-1 + " ");
                else {
                    sb.append(dist[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static boolean inRange(int r, int c) {
        return 0<= r && r < N && 0 <= c && c < M;
    }
}
