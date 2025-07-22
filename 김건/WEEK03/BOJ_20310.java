package Baekjoon.WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20310 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        int z = 0, o = 0;
        char[] array = input.toCharArray();
        for (char c : array) {
            if (c=='0') z++;
            else o++;
        }

        z /= 2;
        o /= 2;
        for (char c : array) {
            if (c=='0') {
                if (z-->0) {
                    sb.append(0);
                }
            }
            else {
                if (o-->0) continue;
                sb.append(1);
            }
        }


        System.out.println(sb.toString());
    }
}
