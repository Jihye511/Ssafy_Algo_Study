import java.util.*;
import java.io.*;

public class Boj_1806_부분합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        int left = 0;
        int right = 0;
        int temp = arr[0];
        while (left <= right && right < N) {
            if (temp < S) {
                right++;
                if (right < N)
                    temp += arr[right];
            }

            if (temp >= S) {
                ans = Math.min(ans, right - left + 1);
                temp -= arr[left++];
            }
        }

        if (ans == Integer.MAX_VALUE)
            System.out.println(0);
        else {
            System.out.println(ans);
        }
    }
}
