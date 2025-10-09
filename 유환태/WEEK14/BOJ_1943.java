package boj;

import java.util.*;
import java.io.*;

public class BOJ_1943 {
    static class Coin{
        int price;
        int cnt;
        Coin(int p, int c){
            this.price = p;
            this.cnt = c;
        }
    }
    static Coin[] coin;
    static boolean[][] DP;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        for(int input = 0; input < 3; input++){
            int N = Integer.parseInt(br.readLine());
            coin = new Coin[N];
            int sum = 0;
            for(int n = 0; n < N; n++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                coin[n] = new Coin(p,c);
                sum += p*c;
            }

            if(sum%2==1){
                System.out.println("0");
            }else{
                sum /= 2;
                DP = new boolean[N+1][sum+1];
                DP[0][0] = true;
                for(int i = 1; i <= N; i++){
                    Coin cur = coin[i-1];
                    for(int j=0;j<=sum;j++){
                        if(DP[i-1][j]){
                            for(int k =0; k <= cur.cnt; k++){
                                int temp = j + cur.price * k;

                                if(temp <= sum){
                                    DP[i][temp] = true;
                                }
                            }
                        }
                    }
                }
                if(DP[N][sum]){
                    System.out.println("1");
                }else{
                    System.out.println("0");
                }
            }
        }
    }
}
