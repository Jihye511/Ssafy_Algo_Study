import java.io.*;
import java.util.*;
public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static int[] arrive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        arrive = new int[2];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] ==2){
                    arrive[0] = i;
                    arrive[1] = j;
                }
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && map[i][j] !=0){
                    sb.append(-1).append(" ");
                }else{
                    sb.append(map[i][j]+" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static int[] dx = {-1,1 ,0,0};
    static int[] dy = {0,0,-1,1};
    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(arrive);
        visited[arrive[0]][arrive[1]] = true;
        map[arrive[0]][arrive[1]] = 0;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i=0;i<4;i++){
                int nx = cur[0]+dx[i];
                int ny = cur[1]+dy[i];

                if(nx<0 || nx>=n ||ny<0 ||ny>=m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] ==0) continue;

                visited[nx][ny] = true;
                map[nx][ny] = map[cur[0]][cur[1]] +1;
                q.offer(new int[]{nx,ny});
            }
        }

    }
}
