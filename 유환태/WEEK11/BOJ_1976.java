package boj;

import java.util.*;
import java.io.*;

public class BOJ_1976 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N =  Integer.parseInt(br.readLine());
        int M =  Integer.parseInt(br.readLine());

        int[][] graph = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=0;k<N;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(graph[i][k]==1 && graph[k][j]==1){
                        graph[i][j]=1;
                    }
                }
            }
        }
        int[] trip = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            trip[i] = Integer.parseInt(st.nextToken());
        }

        boolean valid = true;
        for(int i=1;i<M;i++){
            if(trip[i]!=trip[i-1]){
                if(graph[trip[i-1]-1][trip[i]-1]==0){
                    valid = false;
                }
            }
        }

        if(valid){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
