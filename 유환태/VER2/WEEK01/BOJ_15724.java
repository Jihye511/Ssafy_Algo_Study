package boj;

import java.util.*;
import java.io.*;

public class BOJ_15724 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] area = new int[N][M];

        for(int r = 0; r < N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++){
                area[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if(r==0&c==0) {
                    continue;
                }else if(r==0) {
                    area[r][c] += area[r][c-1];
                }else if(c==0) {
                    area[r][c] += area[r-1][c];
                }else {
                    area[r][c] = area[r][c]+ area[r-1][c] + area[r][c-1] - area[r-1][c-1];
                }
            }
        }

        int K = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            int sum = 0;
            if(x1==0&&y1==0) {
                sum = area[x2][y2];
            }else if(x1==0) {
                sum = area[x2][y2] - area[x2][y1-1];
            }else if(y1==0) {
                sum = area[x2][y2] - area[x1-1][y2];
            }else {
                sum = area[x2][y2] - area[x2][y1-1] - area[x1-1][y2] + area[x1-1][y1-1];
            }

            sb.append(sum +"\n");

        }
        System.out.println(sb.toString());

    }
}
