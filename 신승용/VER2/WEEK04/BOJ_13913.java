package 신승용.VER2.WEEK04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13913 {
    static int[] dx = {-1, 1, 2};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    static void bfs(int N, int K){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(N);

        boolean[] visited = new boolean[100_001];
        int[] dist = new int[100_001];
        int[] parent = new int[100_001];

        visited[N] = true;
        parent[N] = -1;

        while(!queue.isEmpty()){
            int cur =  queue.poll();

            if(cur == K) break;

            for (int i = 0; i < dx.length; i++) {
                if(i != 2){
                    int next = cur + dx[i];
                    if(next < 0 || next >= 100_001) continue;
                    if(visited[next]) continue;
                    visited[next] = true;
                    parent[next] = cur;
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                } else if(i==2){
                    int next = cur * dx[i];
                    if(next < 0 || next >= 100_001) continue;
                    if(visited[next]) continue;
                    visited[next] = true;
                    parent[next] = cur;
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }

        int next = K;
        ArrayList<Integer> list = new ArrayList<>();

        while(next != -1){
            list.add(next);
            next = parent[next];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(dist[K]);
        System.out.println(sb.toString());
    }
}
