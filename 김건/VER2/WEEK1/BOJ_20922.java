package Baekjoon.VER2.WEEK1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] seq = new int[N];
        int[] arr = new int[100001];

        st = new StringTokenizer(br.readLine());

        int s=0, l=0, max=0;
        for (int i=0; i<N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());

            arr[seq[i]]++;
            l++;
            while (arr[seq[i]]>M) {
                arr[seq[s++]]--;
                l--;
            }

            max = Math.max(max, l);
        }

        System.out.println(max);
    }
}
