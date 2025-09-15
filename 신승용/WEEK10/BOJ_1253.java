package 신승용.WEEK10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1253 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N-1;

            while (left < right) {
                if(left == i){
                    left++;
                    continue;
                }

                if(right == i){
                    right--;
                    continue;
                }

                int sum = arr[left] + arr[right];

                if(sum == arr[i]){
                    answer++;
                    break;
                } else if (sum < arr[i]){
                    left++;
                } else {
                    right--;
                }
                
            }
        }

        System.out.println(answer);

    }
}
