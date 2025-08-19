package WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_1283 {

    static StringBuilder sb;
    static boolean[] used;
    static int iii = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i=0; i<N; ++i) {
            arr[i] = br.readLine();
        }

        used = new boolean[26];
        sb = new StringBuilder();

        for (String s : arr) {
            ++iii;
            add(s);
            sb.append("\n");
        }

        System.out.println(sb);

    }

    public static void add(String str) {
        boolean finished = false;
        String[] split = str.split(" ");
        StringBuilder tmp = new StringBuilder();
        for (String s : split) {
//            System.out.println(s);
            int idx = 0;
            if (Character.isLowerCase(s.charAt(0))) {
                idx = s.charAt(0) - 'a';
            }
            else {
                idx = s.charAt(0) - 'A';
            }
            if (!used[idx] && !finished) {
                used[idx] = true;
                tmp.append(s.replaceFirst(String.valueOf(s.charAt(0)), changeStr(s.charAt(0)))).append(" ");
                finished = true;
                continue;
            }
            tmp.append(s).append(" ");
        }

        if (finished) {
            sb.append(tmp);
            return;
        }

        for (int i=0; i<str.length(); ++i) {
            if (!Character.isAlphabetic(str.charAt(i))) {
                continue;
            }

            int idx = 0;
            if (Character.isLowerCase(str.charAt(i))) {
                idx = str.charAt(i) - 'a';
            }
            else {
                idx = str.charAt(i) - 'A';
            }
            if (!used[idx]) {
                used[idx] = true;
                sb.append(str.replaceFirst(String.valueOf(str.charAt(i)), changeStr(str.charAt(i))));
                return;
            }
        }

        sb.append(str);
    }

    public static String changeStr(char c) {
        return "[" + c + "]";
    }
}
