import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static long B;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        map = new int[N][N];
        for(int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] ans = pow(map, B);
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++){
                sb.append(ans[i][j] % 1000).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
    public static int[][] pow(int[][] temp, long b){
        if(b==1){
            return temp;
        }

        int[][] half = pow(temp, b/2);
        int[][] res = cal(half, half);
        if((b % 2) == 1){
            res = cal(res,temp);
        }
        return res ;
    }

    //행렬 계산값
    public static int[][] cal(int[][] X, int[][] Y){
        int[][] val = new int[N][N];
        for(int i =0; i<N; i++){
            for(int k =0; k<N; k++){
                int xik  = X[i][k];
                if(xik == 0) continue;
                for(int j=0; j<N; j++){
                    val[i][j] = (int)((val[i][j] + (long) xik * Y[k][j])%1000);
                }
            }
        }
        return val;
    }
}
