package 신승용.VER2.WEEK01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15724 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] sum = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i==0 && j==0){
                    sum[i][j] = map[i][j];
                } else if(i==0){
                    sum[i][j] = sum[i][j-1] + map[i][j];
                } else if(j==0){
                    sum[i][j] = sum[i-1][j] + map[i][j];
                } else {
                    sum[i][j] = sum[i-1][j] + sum[i][j-1] - sum[i-1][j-1] + map[i][j];
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int sX = Integer.parseInt(st.nextToken())-1;
            int sY = Integer.parseInt(st.nextToken())-1;
            int eX = Integer.parseInt(st.nextToken())-1;
            int eY = Integer.parseInt(st.nextToken())-1;

            System.out.println(sum[eX][eY]
                - (sX > 0 ? sum[sX-1][eY] : 0)
                - (sY > 0 ? sum[eX][sY-1] : 0)
                + (sX > 0 && sY > 0 ? sum[sX-1][sY-1] : 0));
        }

    }
}
