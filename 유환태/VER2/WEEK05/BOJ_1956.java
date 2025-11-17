package boj;

import java.util.*;
import java.io.*;

public class BOJ_1956 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] graph = new int[V][V];

        for(int v = 0; v < V; v++){
            Arrays.fill(graph[v], Integer.MAX_VALUE);
        }

        for(int e = 0; e < E; e++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
        }

        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE){
                        graph[i][j] = Math.min(graph[i][j],graph[i][k] + graph[k][j]);
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int v = 0; v < V; v++) {
            ans = Math.min(ans, graph[v][v]);
        }

        System.out.println(ans==Integer.MAX_VALUE?-1:ans);

    }
}
