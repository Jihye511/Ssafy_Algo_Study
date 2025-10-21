package 신승용.WEEK10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int anwer = Integer.MAX_VALUE;

        while (true) {
            
            if(sum >= S){
                anwer = Math.min(anwer, end-start);
                sum -= arr[start++];
            }
            else if(end == N) break;
            else {
                sum += arr[end++];
            }
        }

        System.out.println(anwer == Integer.MAX_VALUE ? 0 : anwer);
    }
}
