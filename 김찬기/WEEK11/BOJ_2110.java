package WEEK11;

import java.io.*;
import java.util.*;

public class BOJ_2110 {

    static int N, C;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int l = 1;
        int r = arr[N-1] - arr[0];

        while (l<=r) {
            int mid = l + (r-l)/2;
//            System.out.println(l + " , " + r);

            if (chk(mid) < C) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }

        }

        System.out.println(r);
    }

    public static int chk(int dist) {
        int cnt = 1;
        int prev = arr[0];

        for (int i=1; i<arr.length; ++i) {
            if (arr[i] - prev >= dist) {
//                System.out.println(arr[i]);
                ++cnt;
                prev = arr[i];
            }
        }

        return cnt;
    }
}
