package Baekjoon.VER2.WEEK2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10830 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] tmp1 = new int[N][N];
        int[][] tmp2 = new int[N][N];
        int[][] tmp3 = new int[N][N];
        int[][] ans = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                tmp1[i][j] = Integer.parseInt(st.nextToken());
                tmp2[i][j] = tmp1[i][j];
                if (i==j)
                    tmp3[i][j] = 1;
            }
        }

        int sum;

        while (B>0) {
            if (B%2==1) {
                for (int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        sum = 0;
                        for (int k=0; k<N; k++) {
                            sum += tmp3[i][k] * tmp2[k][j];
                        }
                        ans[i][j] = sum%1000;
                    }
                }

                for (int i=0; i<N; i++) {
                    for (int j=0; j<N; j++) {
                        tmp3[i][j] = ans[i][j];
                    }
                }
            }
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    sum = 0;
                    for (int k=0; k<N; k++) {
                        sum += tmp1[i][k]*tmp1[k][j];
                    }
                    tmp2[i][j] = sum%1000;
                }
            }

            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    tmp1[i][j] = tmp2[i][j];
                }
            }
            B/=2;
        }
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                sb.append(ans[i][j]+" ");
            }
            sb.append('\n');
        }

        System.out.println(sb.toString());
    }

}
