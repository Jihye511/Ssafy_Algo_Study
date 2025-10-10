package boj;

import java.util.*;
import java.io.*;

public class BOJ_9527 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        Long A = Long.parseLong(st.nextToken());
        Long B = Long.parseLong(st.nextToken());

        System.out.println(count(B)- count(A-1));

    }

    private static long count(Long n) {
        if (n == 0 || n == 1) return n;
        int digit = 0;
        long two_num = 1;
        while(two_num * 2 <= n){
            two_num *= 2;
            digit++;
        }
        return digit * two_num / 2 + (n - two_num + 1) + count(n - two_num);
    }
}
