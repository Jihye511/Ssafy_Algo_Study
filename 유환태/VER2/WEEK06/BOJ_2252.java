package boj;

import java.util.*;
import java.io.*;

public class BOJ_2252 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[N];
        int[] dist = new int[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            graph[a].add(b);
            dist[b]++;
        }

        Queue<Integer> q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            if(dist[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();

            System.out.print(cur+1 + " ");

            for(int next : graph[cur]){
                dist[next]--;
                if(dist[next]==0){
                    q.add(next);
                }
            }

        }




    }
}
