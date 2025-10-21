package 신승용.WEEK01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }
        int M = Integer.parseInt(br.readLine());

        int left = 0;
        int right = max;
        int answer = 0;
        
        while (left <= right) {
            int mid = (left+right)/2;
            int sum = 0;
            for (int i = 0; i < arr.length; i++) {
                sum += Math.min(arr[i], mid);
            }

            if(sum <= M){
                answer = mid;
                left = mid+1;
            } else if (sum > M){
                right = mid-1;
            }
        }

        System.out.println(answer);

    }
}
