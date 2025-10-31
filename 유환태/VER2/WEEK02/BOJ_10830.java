package boj;

import java.util.*;
import java.io.*;

public class BOJ_10830 {
    static int N;
    static long B;
    static long[][] matrix;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());

        matrix = new long[N][N];
        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < N; c++){
                matrix[r][c] = Long.parseLong(st.nextToken()) % 1000;
            }
        }

        long[][] answer = devide(matrix, B);

        for(int r = 0; r < N; r++){
            for(int c = 0; c < N; c++){
                System.out.print(answer[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static long[][] devide(long[][] matrix, long b) {
        if(b==1){
            long[][] ret = new long[N][N];
            for (int i = 0; i < N; i++)
                for (int j = 0; j < N; j++)
                    ret[i][j] = matrix[i][j] % 1000;
            return ret;
        }

        long[][] half = devide(matrix, b/2);
        long[][] sq = multiply(half, half);

        if(b%2==0) return sq;
        else return multiply(sq, matrix);
    }

    private static long[][] multiply(long[][] devide, long[][] devide1) {
        long[][] ret = new long[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    ret[i][j] = (ret[i][j] + (devide[i][k] * devide1[k][j])%1000) % 1000;
                }
            }
        }
        return ret;
    }
}
