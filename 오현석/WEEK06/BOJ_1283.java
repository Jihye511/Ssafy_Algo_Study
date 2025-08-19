import java.io.*;
import java.util.*;

public class Main {
    static Set<Character> used = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String result = shortcut(s);
            sb.append(result).append('\n');
        }
        System.out.println(sb.toString());
    }

    static String shortcut(String s) {

        for (int i = 0; i < s.length(); i++) {
            if (i == 0 || s.charAt(i - 1) == ' ') {
                char ch = s.charAt(i);
                if (Character.isAlphabetic(ch) && !used.contains(Character.toLowerCase(ch))) {
                    used.add(Character.toLowerCase(ch));
                    return markShortcut(s, i);
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isAlphabetic(ch) && !used.contains(Character.toLowerCase(ch))) {
                used.add(Character.toLowerCase(ch));
                return markShortcut(s, i);
            }
        }

        return s;
    }

    static String markShortcut(String s, int idx) {
        StringBuilder sb = new StringBuilder();
        sb.append(s, 0, idx);
        sb.append('[');
        sb.append(s.charAt(idx));
        sb.append(']');
        sb.append(s.substring(idx + 1));
        return sb.toString();
    }
}
