import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[] dx={1,1,1};
    static int[] dy={-1,0,1};
    static int[][] area;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(st.nextToken());

            }
        }
        int result=Integer.MAX_VALUE;
        for(int j=0;j<M;j++){
                result=Math.min(result,dfs(0,j,-1));

        }

        System.out.println(result);


    }
    public static int dfs(int x, int y, int prevDir) {
        if (x == N - 1) return area[x][y];

        int min = Integer.MAX_VALUE;

        for (int d = 0; d < 3; d++) {
            if (d == prevDir) continue; // 같은 방향 연속 불가
            int nx = x + 1;
            int ny = y + dy[d];
            if (ny >= 0 && ny < M) {
            	min = Math.min(min, area[x][y] + dfs(nx, ny, d));
            }

            
        }

        return min;
    }
}
