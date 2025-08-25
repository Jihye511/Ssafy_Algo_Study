package WEEK08;

import java.io.*;
import java.util.*;

public class BOJ_20437 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            Queue<Integer>[] alpha = new Queue[26];
//            Arrays.fill(alpha, new ArrayDeque<>());
            for (int i=0; i<26; ++i) {
                alpha[i] = new ArrayDeque<>();
            }
            for (int i=0; i<W.length(); ++i) {
                int idx = W.charAt(i) - 'a';
                alpha[idx].add(i);
                if (alpha[idx].size() == K) {
                    int curr = alpha[idx].poll();
                    min = Math.min(min, i-curr+1);
                    max = Math.max(max, i-curr+1);
                }
            }

            if (min == Integer.MAX_VALUE) {
                System.out.println(-1);
            }
            else {
                System.out.println(min + " " + max);
            }
        }
    }
}
