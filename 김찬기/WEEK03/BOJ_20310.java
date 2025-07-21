package WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_20310 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int zero = 0;
        int one = 0;
        for (int i=0; i<s.length(); ++i) {
            if (s.charAt(i) == '0') {
                ++zero;
            }
            else {
                ++one;
            }
        }

        zero /= 2;
        one /= 2;

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<s.length(); ++i) {
            char curr = s.charAt(i);
            if (curr == '0') {
                if (zero > 0) {
                    sb.append(curr);
                    --zero;
                }
            }
            else { // 1이고 one개를 모두 지웠다면
                if (one <= 0) {
                    sb.append(curr);
                }
                --one;
            }
        }

        System.out.println(sb);
    }
}
