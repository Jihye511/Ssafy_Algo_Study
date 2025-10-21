package 신승용.WEEK09;

import java.io.*;
import java.util.*;

public class BOJ_22251 {

    static String[] elevator = {
        "1111110",
        "0110000",
        "1101101",
        "1111001",
        "0110011",
        "1011011",
        "1011111",
        "1110000",
        "1111111",
        "1111011"
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] xDigits = getDigits(X, K);

        int count = 0;
        for (int floor = 1; floor <= N; floor++) {
            if (floor == X) continue;

            int[] fDigits = getDigits(floor, K);
            int diff = 0;
            for (int i = 0; i < K; i++) {
                diff += diffDigit(xDigits[i], fDigits[i]);
                if (diff > P) break;
            }

            if (diff > 0 && diff <= P) count++;
        }

        System.out.println(count);
    }

    static int[] getDigits(int num, int K) {
        int[] digits = new int[K];
        for (int i = K - 1; i >= 0; i--) {
            digits[i] = num % 10;
            num /= 10;
        }
        return digits;
    }

    static int diffDigit(int n1, int n2) {
        int diff = 0;
        for (int i = 0; i < 7; i++) {
            if (elevator[n1].charAt(i) != elevator[n2].charAt(i)) diff++;
        }
        return diff;
    }
}