package boj;

import java.util.*;
import java.io.*;

public class BOJ_3687 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] min = new long[101];
        String[] max = new String[101];
        Arrays.fill(min, Long.MAX_VALUE);
        min[2] = 1;
        min[3] = 7;
        min[4] = 4;
        min[5] = 2;
        min[6] = 6;
        min[7] = 8;
        min[8] = 10;

        int[] count = {1, 7, 4, 2, 0, 8};
        for(int i = 9; i<=100; i++){
            for(int j = 2; j <= 7; j++){
                min[i] = Math.min(min[i],(min[i-j]*10) + count[j-2]);
            }
        }

        max[2] = "1";
        max[3] = "7";

        for(int i = 4; i <= 100; i++){
            if(i%2==1){
                max[i] = "7" + max[i-3];
            }else{
                max[i] = max[i-2] + "1";
            }
        }

        for(int i = 0; i < N; i++){
            int T = Integer.parseInt(br.readLine());
            System.out.println(min[T] + " " + max[T]);
        }
    }
}
