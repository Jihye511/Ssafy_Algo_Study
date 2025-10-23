package VER2.WEEK01;

import java.io.*;
import java.util.*;

public class BOJ_20922 {

    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();

        int l = 0;
        int r = 0;
        int length = 0;
        while (r < N) {
            map.put(arr[r], map.getOrDefault(arr[r], 0)+1);
            if (map.get(arr[r]) > K) {
                map.put(arr[r], map.get(arr[r])-1);
                length = Math.max(length, r-l);
                while (arr[l] != arr[r]) {
                    map.put(arr[l], map.get(arr[l])-1);
                    ++l;
                }
                ++l;
            }

            ++r;
        }

        length = Math.max(length, r-l);

        System.out.println(length);
    }
}
