package Baekjoon.WEEK11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2110 {
    static int N, M, s, e;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        s = 1;
        e = arr[N-1] - arr[0] + 1;
        while (s<e) {
            if (validation()) {

            }
        }
    }

    static boolean validation() {
        int lastPos = arr[0], c = 1;

        for (int i=1;i<N;i++) {

        }
        return false;
    }
}
