import java.util.*;
import java.io.*;

public class Boj_9935_문자열폭발 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] bomb = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : input) {
            sb.append(c);                  
            if (c != bomb[bomb.length - 1])
                continue;

            if (sb.length() >= bomb.length) {
                boolean match = true;
                int m = bomb.length;
                for (int j = 0; j < m; j++) {
                    if (sb.charAt(sb.length() - m + j) != bomb[j]) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.delete(sb.length() - m, sb.length());
                }
            }
        }

        System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
    }
}
