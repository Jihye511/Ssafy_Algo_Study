import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] indegree;
    static ArrayList<Integer>[] adj;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indegree = new int [N+1];
        adj = new ArrayList[N+1];
        sb = new StringBuilder();

        for (int i = 0; i <= N ; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            adj[A].add(B);
            indegree[B]++;
        }

        bfs();

        System.out.println(sb);
    }

    public static void bfs(){
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <=N ; i++) {
            if(indegree[i] == 0) q.add(i);
        }


        while (!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            for(int next : adj[now]){
                indegree[next]--;
                if(indegree[next] == 0){
                    q.add(next);
                }
            }
        }
    }
}
