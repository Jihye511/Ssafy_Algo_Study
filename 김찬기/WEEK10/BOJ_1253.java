package WEEK10;

import java.io.*;
import java.util.*;

public class BOJ_1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int result = 0;
        int idx = 0;
        while (idx < N) {
            int l = 0;
            int r = N-1;

            while (l < r) {
                if (l == idx) {
                    ++l;
                    continue;
                }

                if (r == idx) {
                    --r;
                    continue;
                }

                int sum = arr[l] + arr[r];
                if (sum == arr[idx]) {
                    ++result;
                    break;
                }
                else if (sum < arr[idx]) {
                    ++l;
                }
                else {
                    --r;
                }
            }
            ++idx;
        }

        System.out.println(result);
    }
}
