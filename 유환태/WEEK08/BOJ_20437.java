package boj;

import java.util.*;
import java.io.*;

public class BOJ_20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W =  br.readLine();
            int K =  Integer.parseInt(br.readLine());
            int[] alpha = new int[26];
            for(int i=0; i< W.length(); i++){
                alpha[W.charAt(i)-'a']++;
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            if(K==1){
                System.out.println("1 1");
                continue;
            }
            for(int i=0; i< W.length(); i++){
                if(alpha[W.charAt(i)-'a']< K){
                    continue;
                }
                int count = 1;
                for(int j=i+1; j< W.length(); j++){
                    if(W.charAt(i)==W.charAt(j)){
                        count++;
                    }

                    if(count==K){
                        min = Math.min(min,j-i+1);
                        max = Math.max(max,j-i+1);
                        break;
                    }
                }

            }
            if(min==Integer.MAX_VALUE || max==Integer.MIN_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(min + " " + max);
            }


        }

    }
}
