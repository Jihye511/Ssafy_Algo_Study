package WEEK11;

import java.io.*;
import java.util.*;

public class BOJ_13144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int r = 0;
        Set<Integer> set = new HashSet<>();
        long count = 0;
        for (int i=0; i<N; ++i) {
            while (r < N && !set.contains(arr[r])) {
                set.add(arr[r++]);
            }

            count += r - i;
            set.remove(Integer.valueOf(arr[i]));
        }

        System.out.println(count);
    }
}
