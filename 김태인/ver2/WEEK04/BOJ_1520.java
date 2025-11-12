import java.awt.*;
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dp_map;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp_map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp_map[i][j] = -1;
            }
        }

        int result = dfs(0, 0);
        System.out.println(result);

    }

    public static int dfs(int x, int y){
        if(x == N - 1 && y == M - 1) return 1;
        if (dp_map[x][y] != -1) return dp_map[x][y];


        int sum = 0;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (check(nx, ny)) continue;
            if (map[nx][ny] < map[x][y]) sum += dfs(nx, ny);
        }

        dp_map[x][y] = sum;
        return dp_map[x][y];
    }



    public static boolean check(int nx, int ny){
        return nx < 0 || nx >= N || ny < 0 || ny >= M;
    }
}
