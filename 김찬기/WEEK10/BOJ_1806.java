package WEEK10;

import java.io.*;
import java.util.*;

public class BOJ_1806 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = 0;

        int sum = arr[0];
        int min = Integer.MAX_VALUE;
        while (true) {
            if (sum >= S) {
                min = Math.min(min, r-l+1);
                sum -= arr[l];
                if (l == r) {
                    ++r;
                    if (r >= N) {
                        break;
                    }
                    sum += arr[r];
                }
                ++l;
            }
            else {
                ++r;
                if (r >= N) {
                    break;
                }
                sum += arr[r];
            }
        }

        min = min == Integer.MAX_VALUE ? 0 : min;
        System.out.println(min);
    }
}
