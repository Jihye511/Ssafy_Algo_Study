import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        int left = 0;
        int right = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int result = right;

        while (left <= right){
            int mid = (left + right) / 2;
            int cnt = 1;
            int cur_sum = 0;
            for (int i = 0; i < N; i++) {
                cur_sum += arr[i];
                if(cur_sum > mid){
                    cnt ++;
                    cur_sum = arr[i];
                }

            }
            if (cnt <= M) {
                right = mid-1;
                result = mid;
            }
            else left = mid + 1;

        }

        System.out.println(result);

    }
}
