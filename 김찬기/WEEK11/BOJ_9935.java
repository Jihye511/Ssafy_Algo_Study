package WEEK11;

import java.io.*;
import java.util.*;

public class BOJ_9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String trg = br.readLine();

        Deque<Character> stack = new ArrayDeque<>();
        char[] arr = new char[trg.length()];

        for (int i=0; i<str.length(); ++i) {
            stack.push(str.charAt(i));

            if (stack.size() >= trg.length() && stack.peek() == trg.charAt(trg.length()-1)) {
                int idx;
                for (idx = 0; idx<trg.length(); ++idx) {
                    char curr = stack.pop();
                    arr[idx] = curr;
                    if (curr != trg.charAt(trg.length()-1-idx)) {
                        break;
                    }
                }

                if (idx < trg.length()) {
                    while (idx >= 0) {
                        stack.push(arr[idx]);
                        --idx;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) {
            sb.append("FRULA");
        }
        else {
            while (!stack.isEmpty()) {
                sb.append(stack.pollLast());
            }
        }

        System.out.println(sb);
    }
}
