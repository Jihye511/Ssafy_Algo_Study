import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] now;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        now = new int[N];
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            now[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][40001];
        dp[0][0] = true;

        for (int i = 1; i <= N; i++) {
            int weight = now[i-1];
            for (int j = 0; j <= 40000 ; j++) {
                if(dp[i-1][j]){
                    dp[i][j] = true;
                    if(j + weight <= 40000) dp[i][j + weight] = true;
                    dp[i][Math.abs(j - weight)] = true;                }
            }
        }


        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            sb.append(dp[N][next] ? "Y " : "N ");

        }

        System.out.println(sb);

    }
}
