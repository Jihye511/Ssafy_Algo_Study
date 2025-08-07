package WEEK05;

import java.io.*;
import java.util.*;

public class BOJ_20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < N) {
            freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            if (freq.get(arr[i]) > K) {
//                System.out.println(arr[i] + " , " + i);
                while (j <= i) {
                    freq.put(arr[j], freq.get(arr[j])-1);
                    ++j;
                    if (arr[j-1] == arr[i]) {
                        break;
                    }
                }
            }
            ++i;
            max = Math.max(max, i-j);
        }

        System.out.println(max);
    }
}
