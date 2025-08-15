import java.util.*;
import java.io.*;

public class Boj_1283_단축키지정 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] options = new String[N];
        for (int i = 0; i < N; i++) {
            options[i] = br.readLine();
        }

        Set<Character> alpha = new HashSet<>();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean flag;
        for (String o : options) {
            flag = false;
            //각 옵션 단어 순회
            String[] parse = o.split(" ");
            StringBuilder sb = new StringBuilder();
            for (String p : parse) {
                if (flag) {
                    sb.append(p + " ");
                }
                else {
                    String lower = p.toLowerCase();
                    if (alpha.add(lower.charAt(0))) {
                        sb.append("[" + p.charAt(0) + "]" + p.substring(1,p.length()) + " ");
                        flag = true;
                    }
                    else {
                        sb.append(p + " ");
                    }
                }
            }

            if (flag) {
                bw.write(sb + "\n");
                continue;
            }

            sb.setLength(0);

            //첫 알파벳 X
            char[] chars = o.toLowerCase().toCharArray();
            for (int i = 0; i < o.length(); i++) {
                if (chars[i] != ' ' && alpha.add(chars[i])) {
                    sb.append("[" + o.charAt(i) + "]");
                    if (i != o.length()-1)
                        sb.append(o.substring(i+1,o.length()));
                    break;
                }
                else {
                    sb.append(o.charAt(i));
                }
            }
            bw.write(sb + "\n");
        }

        bw.flush();
    }
}
