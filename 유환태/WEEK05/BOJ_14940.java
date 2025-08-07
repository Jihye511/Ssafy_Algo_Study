package boj;

import java.util.*;
import java.io.*;

public class BOJ_14940 {
    static int N, M;
    static int[][] map;
    static class Node{
        int r;
        int c;
        int cnt;
        Node(int r, int c, int cnt){
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
    static Queue<Node> q = new ArrayDeque<>();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st =  new StringTokenizer(br.readLine());
        N =  Integer.parseInt(st.nextToken());
        M =  Integer.parseInt(st.nextToken());
        map= new int[N][M];
        int[][] ans = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int sr = 0, sc = 0;
        for(int i=0;i<N;i++){
            st =  new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==2){
                    sr = i;
                    sc = j;
                    q.add(new Node(sr,sc,0));

                }
            }
        }
       while(!q.isEmpty()){
           Node cur = q.poll();
           ans[cur.r][cur.c] = cur.cnt;

           for(int i=0;i<4;i++){
               int nr = cur.r + dr[i];
               int nc = cur.c + dc[i];

               if(nr>=0&&nc>=0&&nr<N&&nc<M&&!visited[nr][nc]){
                   if(map[nr][nc]==1){
                       q.add(new Node(nr,nc,cur.cnt+1));
                       visited[nr][nc] = true;
                   }
               }
           }
       }

       for(int i=0;i<N;i++){
           for(int j=0;j<M;j++){

               if(map[i][j]==1&visited[i][j]==false){
                   System.out.print("-1"+" ");
               }else{
                   System.out.print(ans[i][j]+" ");
               }
           }
           System.out.println();
       }
    }


}
