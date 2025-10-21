import java.io.*;
import java.util.*;


public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[][] grid,prefixSum;
    static int dx[] = new int[]{0,0,1,1};
    static int dy[] = new int[]{0,1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String s;
        grid = new int[N + 1][N + 1];
        prefixSum = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            s = br.readLine();
            for (int j = 1; j <= N; j++) {
                grid[i][j] = s.charAt(j-1) -'0';
                prefixSum[i][j] = grid[i][j] + prefixSum[i - 1][j] + prefixSum[i][j - 1] - prefixSum[i - 1][j - 1];
            }
        }
        if (prefixSum[N][N] == N*N ||prefixSum[N][N]== 0){
            System.out.println(prefixSum[N][N]==0?0:1);
        }else{
            dfs(N/2,1, 1);
            System.out.println(sb.toString());
        }
    }

    private static void dfs(int n,int x, int y) {
        sb.append('(');
        if (n == 1){
            sb.append(grid[x][y]).append(grid[x][y+1]).append(grid[x+1][y]).append(grid[x+1][y+1]);
        }else{
            for (int i = 0; i < 4; i++) {
                int nx = x +dx[i]*n-1;
                int ny = y + dy[i]*n-1;
                int chk = prefixSum[nx+n][ny+n] - prefixSum[nx+n][ny] - prefixSum[nx][ny+n] + prefixSum[nx][ny];
                if (chk == n*n)sb.append(1);
                else if (chk == 0)sb.append(0);
                else dfs(n/2, nx+1,ny+1);
            }
        }
        sb.append(')');
    }
}
