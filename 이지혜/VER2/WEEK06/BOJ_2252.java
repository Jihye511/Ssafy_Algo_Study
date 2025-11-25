import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static ArrayList<Integer>[] list;
    static int[] cnt;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList[N+1];
        cnt = new int[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int A =Integer.parseInt(st.nextToken());
            int B =Integer.parseInt(st.nextToken());
            list[A].add(B);
            cnt[B]++;
        }
        bfs();
        System.out.println(sb);

    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList<>();
        for(int i =1; i<=N; i++){
            if(cnt[i]==0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur).append(" ");
            for(int i =0; i<list[cur].size(); i++){
                int next = list[cur].get(i);
                cnt[next]--;
                if(cnt[next]==0){
                    q.offer(next);
                }
            }
        }
    }
}
