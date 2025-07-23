package WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_19637 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strings = new String[N];
        int[] powers = new int[N];
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            strings[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; ++i) {
            int power = Integer.parseInt(br.readLine());
//            for (int n=0; n<N; ++n) {
//                if (power <= powers[n]) {
//                    System.out.println(strings[n]);
//                    break;
//                }
//            }
            int idx = binarySearch(0, N-1, powers, power);
//            System.out.println(strings[idx]);
            sb.append(strings[idx]).append("\n");
        }

        System.out.println(sb);
    }

    public static int binarySearch(int lo, int hi, int[] arr, int p) {
        while (lo < hi) {
            int mid = lo + (hi-lo)/2;

            if (p <= arr[mid]) {
                hi = mid;
            }
            else {
                lo = mid+1;
            }
        }

        return lo;
    }
}
