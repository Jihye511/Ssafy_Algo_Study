import java.io.*;
import java.util.*;
public class Main {
    static ArrayList<Integer>[] list;
    static int N,M,V;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sb2 = new StringBuilder();
    static boolean[] dfs_v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);

        }
        for(int i =1;i<=N; i++){
            Collections.sort(list[i]);
        }
        dfs_v = new boolean[N+1];
        dfs_v[V]= true;
        dfs(V);
        bfs();
        sb.append("\n");
        sb.append(sb2);
        System.out.println(sb);
    }

    public static void dfs(int v){
        sb.append(v).append(" ");
        for(int i =0; i<list[v].size(); i++){
            int c = list[v].get(i);
            if(!dfs_v[c]){
                dfs_v[c] = true;
                dfs(c);
            }
        }
    }

    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        q.offer(V);
        visited[V] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            sb2.append(cur).append(" ");
            for(int i: list[cur]){
                if(!visited[i]){
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
