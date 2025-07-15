package boj;

import java.util.*;
import java.io.*;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        String line =  br.readLine();

        char[] numbers=  line.toCharArray();
        int idx = 0;

        int cur = 1;
        String str_cur = Integer.toString(cur);
        char[] cur_numbers = str_cur.toCharArray();

        while(idx<numbers.length){
            for(int i=0;i<cur_numbers.length;i++){
                if(numbers[idx]==cur_numbers[i]){
                    idx++;
                }
                if(idx==numbers.length){
                    break;
                }
            }
            cur++;
            str_cur = Integer.toString(cur);
            cur_numbers = str_cur.toCharArray();

        }
        System.out.println(cur-1);


    }
}
