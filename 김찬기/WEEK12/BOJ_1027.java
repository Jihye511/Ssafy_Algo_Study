package WEEK12;

import java.io.*;
import java.util.*;

public class BOJ_1027 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; ++i) {
            int l = left(i);
            int r = right(i);
//            System.out.println(l + ", " + r);
            max = Math.max(max, r + l);
        }

        System.out.println(max);

    }

    public static int left(int idx) {
        int cnt = 0;

        double prev = 0;

        for (int i=idx-1; i>=0; --i) {
            double v = (double) (arr[idx] - arr[i]) / (idx - i);
            if (i == idx-1 || v < prev) {
                ++cnt;
                prev = v;
            }
        }

        return cnt;
    }

    public static int right(int idx) {
        int cnt = 0;

        double prev = 0;

        for (int i=idx+1; i<N; ++i) {
            double v = (double) (arr[i] - arr[idx]) / (i - idx);
            if (i == idx+1 || v > prev) {
                ++cnt;
                prev = v;
            }
        }

        return cnt;
    }
}
