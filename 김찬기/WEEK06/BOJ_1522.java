package WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_1522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int cntA = 0;
        for (int i=0; i<arr.length; ++i) {
            if (arr[i] == 'a') {
                ++cntA;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i=0; i<arr.length; ++i) {
            int cntB = 0;

            int cnt = 0;
            while (cnt < cntA) {
                int idx = (i + cnt) % arr.length;

                if (arr[idx] == 'b') {
                    ++cntB;
                }

                ++cnt;
            }

            min = Math.min(min, cntB);
        }

        System.out.println(min);
    }
}
