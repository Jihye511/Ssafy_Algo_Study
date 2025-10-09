import java.util.*;
import java.io.*;

public class Boj_2169_로봇조종하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int INF = -1000000000;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //왼쪽, 오른쪽, 아래로 이동



        int[] dpPrev = new int[M+1];
        Arrays.fill(dpPrev, INF);
        int[] dpCurr = new int[M+1];
        int[] L = new int[M+1];
        int[] R = new int[M+1];

        //위 -> 아래, 왼쪽 -> 오른쪽, 오른쪽 -> 왼쪽
        //초기화
        dpPrev[1] = map[1][1];
        for (int j = 2; j <= M; j++) {
            dpPrev[j] = dpPrev[j-1] + map[1][j];
        }

        // 아래로 이동
        for (int i = 2; i <= N; i++) {
            // 왼 -> 오
            L[1] = dpPrev[1] + map[i][1];
            for (int j = 2; j <= M; j++) {
                L[j] = Math.max(L[j-1], dpPrev[j]) + map[i][j];
            }

            // 오 -> 왼
            R[M] = dpPrev[M] + map[i][M];
            for (int j = M-1; j >= 1; j--) {
                R[j] = Math.max(R[j+1], dpPrev[j]) + map[i][j];
            }

            for (int j = 1; j <= M; j++) {
                dpCurr[j] = Math.max(L[j], R[j]);
            }

            dpPrev = dpCurr.clone();
        }

        System.out.println(dpPrev[M]);
    }
}
