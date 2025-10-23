import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] input = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;

        int[] nums = new int[100001];

        int max = 0;
        int temp = 0;
        while (end < N && start <= end) {
            int curr = input[end];
            if (nums[curr] < K) {
                end++;
                temp++;
                nums[curr]++;
                max = Math.max(max,temp);
            }
            else {
                nums[input[start]]--;
                start++;
                temp--;
            }
        }
        System.out.println(max);
    }
}
