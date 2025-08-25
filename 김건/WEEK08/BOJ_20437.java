package Baekjoon.WEEK8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_20437 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int l, idx, minL, maxL, K, T = Integer.parseInt(br.readLine());
        Queue<Integer>[] que = new ArrayDeque[26];
        for (int i=0; i<26; i++) {
            que[i] = new ArrayDeque<>();
        }
        char[] arr;

        int[] count;

        boolean f;

        for (int testCase = 0; testCase<T; testCase++) {
            arr = br.readLine().toCharArray();
            K = Integer.parseInt(br.readLine());
            maxL = 0;
            minL = arr.length;
            count = new int[26];
            f = false;

            for (int i=0; i<26; i++) {
                que[i].clear();
            }

            for (int i=0; i<arr.length; i++) {
                idx = arr[i]-'a';
                count[idx]++;
                que[idx].add(i);
                if (count[idx]==K) {
                    count[idx]--;
                    f = true;
                    l = i-que[idx].poll()+1;
                    minL = Math.min(minL, l);
                    maxL = Math.max(maxL, l);
                }
            }


            if (f) {
                sb.append(minL).append(' ').append(maxL).append('\n');
            }
            else {
                sb.append(-1).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}
