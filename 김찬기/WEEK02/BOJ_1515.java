package WEEK02;

import java.io.*;
import java.util.*;

/**
 * 세준이 1~N까지 수를 차례로 씀
 * 다솜이가 몇 개 지움
 * 세준이가 다시 쓸려는데, N이 기억나지 않음
 * 지우고 남은 수가 주어졌을 때, N의 최솟값은?
 */

public class BOJ_1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int curr = 0;
        int idx = 0;

        while (idx < arr.length) {
            ++curr;
            String str = String.valueOf(curr);
            for (int i=0; i<str.length() && idx<arr.length; i++) {
                if (str.charAt(i) == arr[idx]) {
                    ++idx;
                }
            }


        }

        System.out.println(curr);
    }
}
