import java.util.*;
import java.io.*;

public class Main {

    static int R, C, result;
    static char[][] board;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];

        String temp;
        for (int i = 0; i < R; i++) {
            temp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        boolean[] alpha_visited = new boolean[26];
        boolean[][] board_visited = new boolean[R][C];

        board_visited[0][0] = true;
        alpha_visited[board[0][0] - 'A'] = true;

        result = 0;
        dfs(0, 0, alpha_visited, board_visited, 1);

        System.out.println(result);
    }

    public static void dfs(int x, int y, boolean[] alpha_visited, boolean[][] board_visited, int cnt){

        int nx, ny;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if(nx < 0 || nx >= R || ny < 0 || ny >= C
                    || board_visited[nx][ny] || alpha_visited[board[nx][ny] - 'A']) continue;

            board_visited[nx][ny] = true;
            alpha_visited[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, alpha_visited, board_visited, cnt + 1);
            board_visited[nx][ny] = false;
            alpha_visited[board[nx][ny] - 'A'] = false;

        }

        result = Math.max(result, cnt);

    }

}
