package Baekjoon.WEEK14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2169 {
    static int R, C;
    static int[][] map;
    static int[][] v;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        v = new int[R][C];
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum=0;
        if (C==1) {
            for (int i=0; i<R; i++) {
                sum+=map[i][0];
            }
        }
        else if (R==1){
            for (int i=0; i<C; i++) {
                sum+=map[0][i];
            }
        }
        else {
            for (int i = 0; i < C; i++) {
                sum+=map[0][i];
                v[1][i]=sum;
            }
            for (int i = 1; i < R - 1; i++) {
                sum=v[i][0]+map[i][0];
                v[i+1][0] = sum;
                for (int j = 1; j < C; j++) {
                    if (v[i][j]>sum) {
                        sum=v[i][j];
                    }
                    sum+=map[i][j];
                    v[i+1][j]=sum;
                }

                sum=v[i][C-1]+map[i][C-1];
                if (sum>v[i+1][C-1])
                    v[i+1][C-1] = sum;
                for (int j = C - 2; j >= 0; j--) {
                    if (v[i][j]>sum) {
                        sum=v[i][j];
                    }
                    sum+=map[i][j];
                    if (sum>v[i+1][j])
                        v[i+1][j]=sum;
                }
            }
            sum = v[R-1][0]+map[R-1][0];
            for (int i = 1; i < C; i++) {
                if (v[R-1][i]>sum) {
                    sum=v[R-1][i];
                }
                sum+=map[R-1][i];
            }
        }
        System.out.println(sum);
    }
}
