package Baekjoon.WEEK6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1522 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int min = Integer.MAX_VALUE;
        int aC = 0;

        for (char c : arr) {
            if (c == 'a') aC++;
        }

        for (int i = 0; i < arr.length; i++) {
            int bC = 0;

            for (int j = i; j < i + aC; j++) {
                if (arr[j % arr.length] == 'b') bC++;
            }
            min = Math.min(min, bC);
        }

        System.out.println(min);
    }
}
