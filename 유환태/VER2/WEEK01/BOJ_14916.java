package boj;

import java.util.*;
import java.io.*;

public class BOJ_14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer n = Integer.parseInt(br.readLine());

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i <= n /5; i++){
            if((n - i * 5)%2==0){
                ans = Math.min(i + (n - i * 5)/2, ans);
            }
        }

        System.out.println(ans==Integer.MAX_VALUE?-1:ans);
    }
}
