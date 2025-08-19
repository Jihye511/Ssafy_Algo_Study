import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[] alpha = new boolean[26];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = line.split(" ");
            boolean marked = false;

            for (int j = 0; j < words.length; j++) {
                char firstChar = Character.toUpperCase(words[j].charAt(0));
                if (firstChar >= 'A' && firstChar <= 'Z') {
                    int idx = firstChar - 'A';
                    if (!alpha[idx]) {
                        alpha[idx] = true;
                        words[j] = "[" + words[j].charAt(0) + "]" + words[j].substring(1);
                        marked = true;
                        break;
                    }
                }
            }

            if (!marked) {
                L: for (int j = 0; j < words.length; j++) {
                    for (int k = 1; k < words[j].length(); k++) {
                        char c = Character.toUpperCase(words[j].charAt(k));
                        if (c >= 'A' && c <= 'Z') {
                            int idx = c - 'A';
                            if (!alpha[idx]) {
                                alpha[idx] = true;
                                words[j] = words[j].substring(0, k) + "[" + words[j].charAt(k) + "]" + words[j].substring(k + 1);
                                marked = true;
                                break L;
                            }
                        }
                    }
                }
            }

            System.out.println(String.join(" ", words));
        }
    }
}
