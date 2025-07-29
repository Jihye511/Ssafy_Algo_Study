package boj;

import java.util.*;
import java.io.*;

public class Main11501 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

         int T =  Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
         for(int i=0;i<T;i++){
             int N =  Integer.parseInt(br.readLine());
             int[] costs = new int[N];

             st = new StringTokenizer(br.readLine());
             for(int j=0;j<N;j++){
                 costs[j] = Integer.parseInt(st.nextToken());
             }
             int save = 0;
             long sum = 0;
             for(int j = N-1; j>=0;j--){
                 if(save==0){
                     save = costs[j];
                 }else{
                     if(costs[j]<=save){
                         sum += save - costs[j];
                     }else{
                         save = costs[j];
                     }
                 }
             }


             sb.append(sum + "\n");

         }
         System.out.println(sb.toString());
    }
}
