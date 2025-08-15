import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] used = new boolean[26];

        StringBuilder out = new StringBuilder();
        for (int line = 0; line < n; line++) {
            String s = br.readLine();

            int choose = -1;

            // 첫 글자 먼저
            for (int i = 0; i < s.length(); i++) {
                if (i == 0 || s.charAt(i - 1) == ' ') {
                    char c = s.charAt(i);
                    if (Character.isLetter(c)) {
                        int idx = Character.toLowerCase(c) - 'a';
                        if (idx >= 0 && idx < 26 && !used[idx]) {
                            used[idx] = true;
                            choose = i;
                            break;
                        }
                    }
                }
            }

            //왼쪽→오른쪽 전체 스캔
            if (choose == -1) {
                for (int i = 0; i < s.length(); i++) {
                    char c = s.charAt(i);
                    if (Character.isLetter(c)) {
                        int idx = Character.toLowerCase(c) - 'a';
                        if (idx >= 0 && idx < 26 && !used[idx]) {
                            used[idx] = true;
                            choose = i;
                            break;
                        }
                    }
                }
            }

            if (choose == -1) {
                out.append(s).append('\n');
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i == choose) {
                        sb.append('[').append(s.charAt(i)).append(']');
                    } else {
                        sb.append(s.charAt(i));
                    }
                }
                out.append(sb).append('\n');
            }
        }

        System.out.print(out);
        
    }
}
