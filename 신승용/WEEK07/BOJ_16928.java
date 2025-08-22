package 신승용.WEEK07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16928 {
    static int[] dx = {1,2,3,4,5,6};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] events = new int[101];

        for (int i = 0; i < N+M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            events[x] = y;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1,0});
        boolean[] visited = new boolean[101];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int count = cur[1];

            if(events[cx] > 0){
                cx = events[cx];
            }

            if(cx == 100){
                System.out.println(count);
                break;
            }

            for (int i = 0; i < dx.length; i++) {
                int nx = cx + dx[i];
                if(nx <= 100 && !visited[nx]){
                    queue.offer(new int[]{nx, count+1});
                    visited[nx] = true;
                }
            }
        }
    }
}
