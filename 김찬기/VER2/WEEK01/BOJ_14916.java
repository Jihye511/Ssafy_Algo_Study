package VER2.WEEK01;

import java.io.*;
import java.util.*;

public class BOJ_14916 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N < 5 && N % 2 != 0) {
            System.out.println(-1);
        }
        else {
            int five = N / 5;
            if ((N - 5 * five) % 2 != 0 && five > 0) {
                --five;
            }
            N = N - 5 * five;

            int cnt = five + N / 2;
            System.out.println(cnt);
        }
    }
}
