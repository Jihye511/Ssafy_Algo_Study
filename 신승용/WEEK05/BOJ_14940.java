package 신승용.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14940 {
    static int n;
    static int m;
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        int startX = 0, startY = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    startX = i;
                    startY = j;
                }
            }
        }

        bfs(startX, startY);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j]!=0 && !visited[i][j]){
                    sb.append(-1);
                } else {
                    sb.append(map[i][j]);
                }
                if(j < m-1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
    static void bfs(int startX, int startY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];
            int count = cur[2];
            
            map[cx][cy] = count;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m
                && !visited[nx][ny] && map[nx][ny]==1){
                    queue.offer(new int[]{nx, ny, count+1});
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
