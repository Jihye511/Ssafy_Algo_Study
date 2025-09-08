package WEEK10;

import java.io.*;
import java.util.*;

public class BOJ_2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] src = br.readLine().toCharArray();
        char[] dst = br.readLine().toCharArray();

        int result1 = solve(Arrays.copyOf(src, src.length), dst, 0);
        src[0] = src[0] == '0' ? '1' : '0';
        src[1] = src[1] == '0' ? '1' : '0';
//        System.out.println(Arrays.toString(src));
        int result2 = solve(src, dst, 1);

        if (result1 == Integer.MAX_VALUE && result2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(Math.min(result1, result2));
        }
    }

    public static int solve(char[] src, char[] dst, int cnt) {

        for (int i=1; i<src.length; ++i) {
            if (src[i-1] != dst[i-1]) {
                src[i-1] = src[i-1] == '0' ? '1' : '0';
                src[i] = src[i] == '0' ? '1' : '0';
                if (i+1 < src.length) {
                    src[i+1] = src[i+1] == '0' ? '1' : '0';
                }
                ++cnt;
            }
//            System.out.println(Arrays.toString(src));
        }

//        System.out.println("---------------");

        if (Arrays.equals(src, dst)) {
            return cnt;
        }

        return Integer.MAX_VALUE;
    }
}
