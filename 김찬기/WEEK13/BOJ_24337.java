package WEEK13;

import java.io.*;
import java.util.*;

public class BOJ_24337 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 건물 개수
        int a = Integer.parseInt(st.nextToken()); // 가희
        int b = Integer.parseInt(st.nextToken()); // 단비

        if (a + b - 1 > N) {
            System.out.println(-1);
        }
        else {
            int[] arr = new int[N];
            int over = N - (a+b-1);
            if (a > 1) {
                int max = Math.max(a, b);

                for (int i=0; i<over; ++i) {
                    arr[i] = 1;
                }

                int h = 1;
                for (int i=over; i<a+over-1; ++i) {
                    arr[i] = h++;
                }

                arr[a+over-1] = max;

                h = 1;
                for (int i=N-1; i>N-b; --i) {
                    arr[i] = h++;
                }
            }
            else {
                int max = Math.max(a, b);
                arr[0] = max--;
                for (int i=1; i<=over; ++i) {
                    arr[i] = 1;
                }

                for (int i=N-b+1; i<N; ++i) {
                    arr[i] = max--;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        }
    }
}
