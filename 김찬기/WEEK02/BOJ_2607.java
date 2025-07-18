package WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String target = br.readLine();
        int result = 0;
        for (int i=0; i<N-1; ++i) {
            String s = br.readLine();
            if (check(target, s)) {
                ++result;
            }
        }

        System.out.println(result);
    }

    public static boolean check(String target, String source) {
        int gap = Math.abs(target.length() - source.length());
        int diff = 0;
        if (target.length() > source.length()) {
            diff = getDiff(source, target);
        }
        else {
            diff = getDiff(target, source);
        }

        if (gap > 1) {
            return false;
        }
        else if (gap == 1) {
            return diff == 0;
        }

        return diff <= 1;
    }

    public static int getDiff(String small, String large) {
        int cnt = 0;
        int[] alpha = new int[26];

        for (int i=0; i<large.length(); ++i) {
            int idx = large.charAt(i) - 'A';
            ++alpha[idx];
        }

        for (int i=0; i<small.length(); ++i) {
            int idx = small.charAt(i) - 'A';
            --alpha[idx];
            if (alpha[idx] < 0) {
                ++cnt;
            }
        }

        return cnt;
    }
}
