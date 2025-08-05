package 신승용.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int N;
    static int M;
    static int start;
    static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken())-1;

        adjList = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken())-1;
            int e = Integer.parseInt(st.nextToken())-1;

            adjList[v].add(e);
            adjList[e].add(v);
        }

        for (int i = 0; i < N; i++) {
            Collections.sort(adjList[i]);
        }

        dfs(start, new boolean[N]);
        System.out.println();
        bfs(start);

    }

    static void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        boolean[] visited = new boolean[N];
        visited[start] = true;
        StringBuilder sb = new StringBuilder();

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur+1 + " ");

            for (int v : adjList[cur]) {
                if(!visited[v]){
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }

        System.out.println(sb.toString());
    }

    static void dfs(int index, boolean[] visited){
        
        visited[index] = true;
        System.out.print(index+1 + " ");

        for (int v : adjList[index]) {
            if(!visited[v]){
                dfs(v, visited);
            }
        }
    }
}