import java.io.*;
import java.util.*;

public class BOJ_2467 {
    static int[] liquid;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        liquid = new int[N];
        for (int i = 0; i < N; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        long min = Long.MAX_VALUE;
        int l = 0;
        int r = N - 1;
        int l1 = 0;
        int l2 = 0;

        while (l < r) {
            int sum = liquid[l] + liquid[r];
            long absSum = Math.abs(sum);
            if (min > absSum) {
                l1 = liquid[l];
                l2 = liquid[r];
                min = absSum;
                if (min == 0) break;
            }
            if (sum <= 0) l += 1;
            else r -= 1;
        }
        System.out.println(l1 + " " + l2);
    }
}
