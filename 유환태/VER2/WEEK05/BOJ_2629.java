package boj;

import java.util.*;
import java.io.*;

public class BOJ_2629 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        boolean[][] check = new boolean[N+2][40001];

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N+1; i++){
            int w = Integer.parseInt(st.nextToken());

            check[i][w] = true;
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j < check[0].length; j++) {

                if(check[i-1][j]){
                    check[i][j] = true;
                    if(j - w > 0){
                        list.add(j - w);
                    }
                    if(w - j > 0){
                        list.add(w- j);
                    }
                    if(w + j < 40001){
                        list.add(w + j);
                    }
                }
            }

            for(int l : list){
                check[i][l] = true;
            }
        }

        int C = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < C; i++){
            int w = Integer.parseInt(st.nextToken());

            System.out.print(check[N][w]?"Y ":"N ");
        }
    }
}
