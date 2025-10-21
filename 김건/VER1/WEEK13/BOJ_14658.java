package Baekjoon.WEEK13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14658 {
    static int N, M, L, K;



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[][] stars = new int[K][2];

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());

            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }

        int r, maxR, c, maxC, cnt, max = 0;

        for (int i=0; i<K; i++) {
            r = Math.min(N-L, stars[i][0]);
            maxR = r+L;
            for (int j=0; j<K; j++) {
                c = Math.min(M-L,stars[j][1]);
                maxC = c+L;

                cnt = 0;
                for (int k=0; k<K; k++) {
                    if (stars[k][0]>=r&&stars[k][0]<=maxR&&stars[k][1]>=c&&stars[k][1]<=maxC) cnt++;
                }
                max = Math.max(cnt, max);
            }
        }

        System.out.println(K-max);
    }
}
