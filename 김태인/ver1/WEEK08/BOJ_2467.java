import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;
        int result_left = 0;
        int result_right = 0;
        int result = Integer.MAX_VALUE;
        while (left < right){
            int temp = arr[left] + arr[right];
            if(Math.abs(temp) < result){
                result_right = right;
                result_left = left;
                result = Math.abs(temp);

            }

            if (temp < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(arr[result_left] + " " + arr[result_right]);
    }
}
