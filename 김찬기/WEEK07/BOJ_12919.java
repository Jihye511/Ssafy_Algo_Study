package WEEK07;

import java.io.*;
import java.util.*;

public class BOJ_12919 {

    static int result = 0;
    static String s, t;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        recursive(t);

        System.out.println(result);
    }

    public static void recursive(String curr) {
        if (curr.length() < s.length()) {
            return;
        }

        if (curr.equals(s)) {
            result = 1;
            return;
        }

        if (curr.charAt(curr.length()-1) == 'A') {
            recursive(curr.substring(0, curr.length()-1));
        }

        if (curr.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(curr.substring(1, curr.length()));
            recursive(sb.reverse().toString());
        }
    }
}
