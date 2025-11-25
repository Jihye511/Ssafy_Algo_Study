package 신승용.VER2.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] degree = new int[N+1];

        ArrayList<Integer>[] adjList = new ArrayList[N+1];
        for (int i = 0; i < adjList.length; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            adjList[v].add(e);
            degree[e]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if(degree[i]==0){
                queue.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!queue.isEmpty()){
            int cur = queue.poll();
            sb.append(cur).append(" ");

            for (int next : adjList[cur]) {
                degree[next]--;
                if(degree[next] == 0){
                    queue.offer(next);
                }
            }
        }
        
        System.out.println(sb.toString());
    }
}
