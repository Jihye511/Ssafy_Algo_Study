import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, num;
        Node(int x, int y, int num) { this.x = x; this.y = y; this.num = num; }
    }

    static int N, M;
    static int[][] map;
    static List<Node> cctvs = new ArrayList<>();
    static int minCnt = Integer.MAX_VALUE;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = { 0, 0,-1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] >= 1 && map[i][j] <= 5) {
                    cctvs.add(new Node(i, j, map[i][j]));
                }
            }
        }

        dfs(0, map);
        System.out.println(minCnt);
    }

    static void dfs(int depth, int[][] cur) {
        if (depth == cctvs.size()) {
            minCnt = Math.min(minCnt, countBlank(cur));
            return;
        }

        Node c = cctvs.get(depth);
        int[][] dirs;
        switch (c.num) {
            case 1:
                dirs = new int[][]{{0},{1},{2},{3}};
                break;
            case 2:
                dirs = new int[][]{{0,1},{2,3}}; // 상하 / 좌우
                break;
            case 3:
                dirs = new int[][]{{0,3},{3,1},{1,2},{2,0}}; // 상우, 우하, 하좌, 좌상
                break;
            case 4:
                dirs = new int[][]{{0,2,3},{0,1,3},{0,1,2},{1,2,3}}; // 네 방향 중 하나만 빼고
                break;
            case 5:
                dirs = new int[][]{{0,1,2,3}}; // 전방향
                break;
            default:
                dirs = new int[0][];
        }

        for (int[] set : dirs) {
            int[][] next = copy(cur);
            for (int d : set) watch(next, c.x, c.y, d);
            dfs(depth + 1, next);
        }
    }

    // 한 방향으로 감시선 긋기: 벽(6) 전까지 계속 진행
    static void watch(int[][] a, int x, int y, int dir) {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        while (0 <= nx && nx < N && 0 <= ny && ny < M) {
            if (a[nx][ny] == 6) break;
            if (a[nx][ny] == 0) a[nx][ny] = -1;
            nx += dx[dir];
            ny += dy[dir];
        }
    }

    static int countBlank(int[][] a) {
        int c = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (a[i][j] == 0) c++;
        return c;
    }

    static int[][] copy(int[][] origin) {
        int[][] b = new int[N][M];
        for (int i = 0; i < N; i++)
            System.arraycopy(origin[i], 0, b[i], 0, M);
        return b;
    }
}
