package Baekjoon.VER2.WEEK1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_14916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int div = N/5;
        int mod = N%5;
        int ans = 0;
        if (div>0) {
            if (mod==1||mod==3) {
                div--;
                mod+=5;
            }
            ans = div+mod/2;
        }
        else {
            if (mod==1||mod==3) ans = -1;
            else ans = mod/2;
        }

        System.out.println(ans);
    }
}
