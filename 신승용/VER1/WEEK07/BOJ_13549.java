package 신승용.WEEK07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    static void bfs(int N, int K) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{N, 0});
        int[] visited = new int[200_001];
        Arrays.fill(visited, Integer.MAX_VALUE);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cx = cur[0];
            int cTime = cur[1];

            for (int i = 0; i < dx.length; i++) {
                int nx = 0;
                int nTime = 0;
                if(i!=2){
                    nx = cx + dx[i];
                    nTime = cTime + 1;
                } else if(i==2){
                    nx = cx * dx[i];
                    nTime = cTime;
                }
                
                if(nx >= 0 && nx < visited.length && nTime < visited[nx]){
                    queue.offer(new int[]{nx, nTime});
                    visited[nx] = nTime;
                }
            }
        }

        System.out.println(visited[K]);
    }
}
