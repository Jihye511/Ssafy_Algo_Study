import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;
    static int[][] cost;
    static int[] dr = {1,1,1};
    static int[] dc = {-1,0,1};
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        cost = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ans = Integer.MAX_VALUE;    
        for(int i=0;i<M;i++){
            dfs(0, i,4, arr[0][i]);
        }

        
        System.out.println(ans);
    }
    public static void dfs(int r, int c, int d, int sum) {
        if(r==N-1){
            ans = Math.min(ans, sum);
            return;
        }
        for(int i = 0; i < 3; i++){
            if(d!=i){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nr < N && nc >= 0 && nc < M){
                
                    dfs(nr, nc, i, sum + arr[nr][nc]);
                }
            }

        }

    }
}
