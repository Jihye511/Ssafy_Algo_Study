package WEEK09;

import java.io.*;
import java.util.*;

/**
 * 0 1 2
 * 3 4 5
 * 6 7 8
 */

public class BOJ_7682 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            char[] arr = input.toCharArray();

            int cntO = 0;
            int cntX = 0;

            for (int i=0; i<arr.length; ++i) {
                if (arr[i] == 'O') {
                    ++cntO;
                }
                else if (arr[i] == 'X') {
                    ++cntX;
                }
            }

            int gap = cntX - cntO;
            if (gap < 0 || gap >= 2) {
                sb.append("invalid\n");
                continue;
            }

            else if (gap == 1) {
                if (chk(arr, 'O')) {
                    sb.append("invalid\n");
                    continue;
                }
                else if (chk(arr, 'X')) {
                    sb.append("valid\n");
                    continue;
                }
                else if (cntX + cntO == 9) {
                    sb.append("valid\n");
                    continue;
                }
            }

            else {
                if (chk(arr, 'X')) {
                    sb.append("invalid\n");
                    continue;
                }
                else if (chk(arr, 'O')) {
                    sb.append("valid\n");
                    continue;
                }
            }

            sb.append("invalid\n");

        }

        System.out.println(sb);
    }

    public static boolean chk(char[] arr, char c) {
        for (int i=0; i<3; ++i) { // 가로 3개 동일
            int cnt = 0;
            for (int j=0; j<3; ++j) {
                if (arr[3*i + j] == c) {
                    ++cnt;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        for (int i=0; i<3; ++i) { // 세로 3개 동일
            int cnt = 0;
            for (int j=0; j<3; ++j) {
                if (arr[i + 3*j] == c) {
                    ++cnt;
                }
            }

            if (cnt == 3) {
                return true;
            }
        }

        int cnt = 0;
        for (int i=0; i<3; ++i) {
            if (arr[3*i + i] == c) {
                ++cnt;
            }
        }

        if (cnt == 3) {
            return true;
        }

        cnt = 0;
        for (int i=0; i<3; ++i) {
            if (arr[2*i + 2] == c) {
                ++cnt;
            }
        }

        if (cnt == 3) {
            return true;
        }

        return false;
    }
}
