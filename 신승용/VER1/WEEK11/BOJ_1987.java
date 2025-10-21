package 신승용.WEEK11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987 {
    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int startBit = 1 << (map[0][0] - 'A');
        dfs(0, 0, startBit, 1);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int visited, int depth) {
        answer = Math.max(answer, depth);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                int bit = 1 << (map[nx][ny] - 'A');
                if ((visited & bit) == 0) {
                    dfs(nx, ny, visited | bit, depth + 1);
                }
            }
        }
    }
}