package VER2.WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_2343 {

    static int N, M;
    static long l, r;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        l = 0;
        r = 0;
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            l = Math.max(l, arr[i]);
            r += arr[i];
        }

        parametric();

        System.out.println(r);
    }

    public static void parametric() {
        while (l < r) {
            long mid = l + (r-l)/2;
            if (check(mid)) {
                r = mid;
            }
            else {
                l = mid+1;
            }
        }
    }

    public static boolean check(long mid) {
        int cnt = M-1;
        long sum = 0;
        for (int i=N-1; i>=0; --i) {
            sum += arr[i];
            if (sum > mid) {
                --cnt;
                sum = arr[i];
            }
        }

        return cnt >= 0;
    }
}
