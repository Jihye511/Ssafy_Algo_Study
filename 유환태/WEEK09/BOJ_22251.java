package boj;

import java.util.*;
import java.io.*;

public class BOJ_22251 {
    static int N, K, P, X;
    static int[][] m;
    static List<Integer> list;
    static int ans;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        m = new int[10][10];
        int[] number = new int[10];
        number[0] = 0b1110111;
        number[1] = 0b0010010;
        number[2] = 0b1011101;
        number[3] = 0b1011011;
        number[4] = 0b0111010;
        number[5] = 0b1101011;
        number[6] = 0b1101111;
        number[7] = 0b1010010;
        number[8] = 0b1111111;
        number[9] = 0b1111011;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                m[i][j] = Integer.bitCount(number[i] ^  number[j]);
            }
        }


        list = new ArrayList<>();

        String strnum = String.valueOf(X);
        if(K - strnum.length() > 0){
            for(int i = 0; i < K - strnum.length(); i++){
                list.add(0);
            }
        }
        for(int i = 0; i < strnum.length(); i++){
            list.add(Integer.parseInt(strnum.substring(i,i+1)));
        }

        combi(0, new int[K] , new boolean[K]);
        System.out.println(ans);
    }

    private static void combi(int i, int[] num, boolean[] v) {
        if(i == K){
            String max_floor = "";
            for (int j : num) {
                max_floor += j;
            }
            if(Integer.parseInt(max_floor) > N || Integer.parseInt(max_floor) == 0){
                return ;
            }
            int sum = 0;

            for(int j = 0; j < num.length; j++){
                sum += m[list.get(j)][num[j]];

            }
            if(sum >= 1 && sum <= P){
                ans++;
            }
            return ;
        }

        for(int j = 0; j < 10; j++){
            if(!v[i]){
                v[i] = true;
                num[i] = j;
                combi(i+1, num, v);
                v[i] = false;
            }
        }
    }
}
