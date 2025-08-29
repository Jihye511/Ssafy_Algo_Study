import java.util.*;
import java.io.*;

public class Boj_2467_용액 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] liq = new int[N];
        for (int i = 0; i < N; i++) {
            liq[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0;
        int right = N-1;

        int ans1 =  liq[left];
        int ans2 = liq[right];

        int min = Integer.MAX_VALUE;
        while (left < right) {
            int sum = liq[right] + liq[left];
            if (Math.abs(sum)< Math.abs(min)) {
                min = sum;
                ans1 = liq[left];
                ans2 = liq[right];
            }

            if (sum < 0) {
                left++;
            }
            else if (sum == 0) {
                ans1 = liq[left];
                ans2 = liq[right];
                break;
            }
            else {
                right--;
            }
        }

        System.out.println(ans1 + " " + ans2);
    }
}
