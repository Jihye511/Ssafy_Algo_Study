package 신승용.WEEK08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int leftMax = 0;
        int answer = 0;

        for (int i = 1; i < W-1; i++) {
            leftMax = Math.max(leftMax, arr[i-1]);
            int rightMax = 0;
            for (int j = i+1; j < W; j++) {
                rightMax = Math.max(rightMax, arr[j]);
            }

            int sum = Math.min(leftMax, rightMax) - arr[i];

            if(sum > 0){
                answer += sum;
            }
        }

        System.out.println(answer);
    }
}
