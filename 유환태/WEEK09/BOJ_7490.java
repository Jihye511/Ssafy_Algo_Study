package boj;

import java.util.*;
import java.io.*;

public class BOJ_7490 {
    static String[] op = {" ","+", "-"};
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int T =  Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N =  Integer.parseInt(br.readLine());

            recur(0, new int[N-1]);
            sb.append("\n");

        }
        System.out.println(sb.toString());
    }

    private static void recur(int i, int[] num) {
        if(i == N - 1){
            String s = "1";
            for(int k = 2; k <= N; k++){
                s += String.valueOf(op[num[k-2]]);
                s += String.valueOf(k);
            }
            String cur = "+";
            String number = "";
            int sum = 0;
            for(int k = 0; k < s.length(); k++){
                if(s.charAt(k) >= '0' && s.charAt(k) <= '9'){
                    number += String.valueOf(s.charAt(k));
                }
                else if(s.charAt(k) == ' '){
                    continue;
                }else{
                    if(cur.equals("+")){
                        sum += Integer.parseInt(number);
                    }else{
                        sum -= Integer.parseInt(number);
                    }
                    cur = String.valueOf(s.charAt(k));
                    number = "";
                }

            }

            if(cur.equals("+")){
                sum += Integer.parseInt(number);
            }else{
                sum -= Integer.parseInt(number);
            }

            if(sum == 0){
                sb.append(s + "\n");
            }
            return ;
        }

        for(int j=0;j<3;j++){
            num[i] = j;
            recur(i+1, num);
        }
    }
}
