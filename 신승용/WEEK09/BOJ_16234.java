package 신승용.WEEK09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {
    static int[][] map;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean isValid = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j]){
                        if (bfs(i, j, N, L, R, visited)) {
                            isValid = true;
                        }
                    }
                }
            }

            if (!isValid) break;
            answer++;
        }

        System.out.println(answer);
    }

    static boolean bfs(int x, int y, int N, int L, int R, boolean[][] visited){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        boolean isValid = false;
        List<int[]> list = new ArrayList<>();
        int sum = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cy = cur[1];

            list.add(new int[]{cx, cy});
            sum += map[cx][cy];
            count++;

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >=0 && nx<N && ny>=0 && ny<N && Math.abs(map[cx][cy] - map[nx][ny]) >= L
                && Math.abs(map[cx][cy] - map[nx][ny]) <= R && !visited[nx][ny]){
                    queue.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                    isValid = true;
                }
            }
        }

        int num = sum / count;

        for (int[] is : list) {
            map[is[0]][is[1]] = num;
        }

        return isValid;
    }
}
