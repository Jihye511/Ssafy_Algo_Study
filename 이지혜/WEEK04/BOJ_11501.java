import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T =Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] day = new int[N];
            for(int i =0; i<N; i++){
                day[i] = Integer.parseInt(st.nextToken());
            }
            long sum=0L;
            int num = day[N-1];
            for(int i =N-2; i>=0; i--){
               if(num> day[i]){
                   sum += num-day[i];
               }else{
                    num = day[i];
               }
            }
            if(sum<0) sum =0;
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

        }
    }
