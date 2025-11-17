import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] dist = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], 10000000);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            dist[u][v] = cost;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k]+ dist[k][j]) dist[i][j] = dist[i][k]+ dist[k][j];
                }
            }
        }

        int answer = 10000000;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                answer = Math.min(answer, dist[i][j] + dist[j][i]);
            }
        }

        if (answer == 10000000) answer = -1;
        System.out.println(answer);
    }
}
