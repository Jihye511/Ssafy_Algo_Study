package Baekjoon.WEEK11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13144 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] in = new int [N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=1; i<=N; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        long c=0;
        int p=1;
        int[] arr =  new int[100001];
        for (int i=1; i<=N; i++) {
            if (arr[in[i]]!=0&&arr[in[i]]>=p) {
                for (int j = p; j <= arr[in[i]]; j++) {
                    c += i - j;
                }
                p = arr[in[i]] + 1;
            }
            arr[in[i]] = i;
        }
        for (int i=p; i<=N; i++) {
            c+=N-i+1;
        }

        System.out.println(c);
    }
}
