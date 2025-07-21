package boj;

import java.util.*;
import java.io.*;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String S = br.readLine();

        int count_one = 0;
        int count_zero = 0;

        char[] str_arr = S.toCharArray();

        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i)=='0'){
                count_zero++;
            }else{
                count_one++;
            }
        }
        count_zero = count_zero/2;
        count_one = count_one/2;

        while(count_zero>0){
            for(int i=S.length()-1;i>=0;i--){
                if(str_arr[i]=='0'){
                    str_arr[i] = ' ';
                    break;
                }
            }

            count_zero--;
        }

        while(count_one>0){
            for(int i=0;i<str_arr.length;i++){
                if(str_arr[i]=='1'){
                    str_arr[i] = ' ';
                    break;
                }
            }
            count_one--;
        }

        for(int i=0;i<str_arr.length;i++){
            if(str_arr[i]!=' '){
                System.out.print(str_arr[i]);
            }
        }


    }
}
