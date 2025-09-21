import java.util.*;
import java.io.*;

public class Main {


    static int N, M;
    static ArrayList<Integer>[] adj;
    static int[] goal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        int next = 0;
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                next = Integer.parseInt(st.nextToken());
                if(next == 1){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        goal = new int[M+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(bfs() ? "YES" : "NO");

    }

    public static boolean bfs(){
        int idx = 1;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N+1];

        q.add(goal[idx]);
        visited[goal[idx]] = true;

        int now;
        while (!q.isEmpty()){
            now = q.poll();
            for (int next : adj[now]){
                if(!visited[next]){
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        for (int i = 2; i <= M; i++) {
            if(!visited[goal[i]]) return false;
        }

        return true;

    }
}
