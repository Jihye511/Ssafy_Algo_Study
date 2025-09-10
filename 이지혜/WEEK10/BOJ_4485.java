import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] map;
    static int[][] value;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t=1;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N ==0) {
                System.out.println(sb);
                return;
            }
            map = new int[N][N];
            value = new int[N][N];

            for(int i =0; i<N; i++){
                StringTokenizer st= new StringTokenizer(br.readLine());
                for(int j =0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    value[i][j] = Integer.MAX_VALUE;
                }
            }
            value[0][0]=map[0][0];
            dij();
            sb.append("Problem "+t+": "+value[N-1][N-1]).append("\n");
            t++;
        }
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void dij(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2]-b[2]);
        pq.offer(new int[] {0,0, value[0][0]});
        boolean[][] v = new boolean[N][N];
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int i =0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx <0 || nx>=N || ny<0 || ny>=N) continue;
                if(value[nx][ny]>cur[2]+map[nx][ny]){
                    value[nx][ny] = cur[2]+map[nx][ny];
                    if(nx ==N-1 && ny  == N-1) return;
                    pq.offer(new int[]{nx,ny,value[nx][ny]});
                }
            }

        }
    }
}
