package Baekjoon.WEEK6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_17615 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int rC = 0, bC = 0, c = 1;
        char[] arr = br.readLine().toCharArray();
        char before = arr[0], start = arr[0];
        while (c<N&&arr[c]==before) {
            c++;
        }

        int sC = c;
        if (before == 'R') rC += c;
        else bC += c;

        if (c<N) {
            before = arr[c];
            int idx = c;
            c = 1;
            for (int i = idx + 1; i < N; i++) {
                if (arr[i] != before) {
                    if (before == 'R') rC += c;
                    else bC += c;
                    c = 0;
                    before = arr[i];
                }
                c++;
            }
        }

        int ans = Math.min(rC, bC);
        if (arr[arr.length-1]=='R') rC+=c;
        else bC+=c;

        if (start=='R') rC-=sC;
        else bC-=sC;
        System.out.println(Math.min(Math.min(rC, bC), ans));
    }
}
