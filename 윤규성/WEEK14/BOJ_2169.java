import java.io.*;
import java.util.*;

public class Q2169 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] a = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dpPrev = new int[M];
        dpPrev[0] = a[0][0];
        for (int j = 1; j < M; j++) {
            dpPrev[j] = dpPrev[j - 1] + a[0][j];
        }

        for (int i = 1; i < N; i++) {
            int[] left = new int[M];
            int[] right = new int[M];
            int[] dpCurr = new int[M];

            left[0] = dpPrev[0] + a[i][0];
            for (int j = 1; j < M; j++) {
                int fromLeft = left[j - 1];
                int fromUp = dpPrev[j];
                if (fromLeft >= fromUp) {
                    left[j] = fromLeft + a[i][j];
                } else {
                    left[j] = fromUp + a[i][j];
                }
            }

            right[M - 1] = dpPrev[M - 1] + a[i][M - 1];
            for (int j = M - 2; j >= 0; j--) {
                int fromRight = right[j + 1];
                int fromUp = dpPrev[j];
                if (fromRight >= fromUp) {
                    right[j] = fromRight + a[i][j];
                } else {
                    right[j] = fromUp + a[i][j];
                }
            }

            for (int j = 0; j < M; j++) {
                if (left[j] >= right[j]) {
                    dpCurr[j] = left[j];
                } else {
                    dpCurr[j] = right[j];
                }
            }

            dpPrev = dpCurr;
        }

        System.out.println(dpPrev[M - 1]);
    }
}
