import java.io.*;
import java.util.*;
public class Main {
    static int N, L, R;
    static int[][] map;
    static int day;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        day = 0;
        while(true){
            //1. 인구 차 계산 이동가능 확인
            boolean[][] v = new  boolean[N][N];
            int t =0;
            for(int i =0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(!v[i][j]){
                        v[i][j] = true;
                        t +=generate(v,i,j);
                    }
                }
            }
            if(t == 0) break;
            //3. day++
            day++;
        }
        System.out.println(day);
    }
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static int generate(boolean[][] v, int n, int m){
        Queue<int[]> q = new LinkedList<>();
        int hap =0;
        q.offer(new int[]{n,m});
        ArrayList<int[]> list = new ArrayList<>();
        list.add(new int[]{n,m});
        hap += map[n][m];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i =0; i<4; i++){
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || ny<0 || nx>=N || ny>=N)  continue;
                if(v[nx][ny])continue;

                int val = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                if(L<=val && R>=val){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    list.add(new int[]{nx,ny});
                    hap+=map[nx][ny];
                }
            }
        }

        for(int i=0; i<list.size(); i++){
            int newval = hap/list.size();
            int[]  cur =list.get(i);
            map[cur[0]][cur[1]] = newval;
        }
        return list.size()>1 ? 1: 0;
    }
}
