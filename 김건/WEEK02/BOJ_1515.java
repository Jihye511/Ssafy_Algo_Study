package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1515 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0, i=0;
        char[] input;
        input =  br.readLine().toCharArray();
        while (i<input.length) {
            char[] digits = Integer.toString(++count).toCharArray();
            for (int digit:digits) {
                if (i<input.length && input[i]==digit) {
                    i++;
                }
            }
        }

        System.out.println(count);
    }
}
