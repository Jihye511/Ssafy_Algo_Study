import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = Integer.parseInt(br.readLine());

        Deque<Character> left = new LinkedList<>();
        Deque<Character> right = new LinkedList<>();

        // 초기 문자열을 left에 넣음 (커서가 맨 끝에 있음)
        for (char c : str.toCharArray()) {
            left.addLast(c);
        }

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String cmd = input[0];

            switch (cmd) {
                case "L":
                    if (!left.isEmpty()) {
                        right.addFirst(left.removeLast());
                    }
                    break;
                case "D":
                    if (!right.isEmpty()) {
                        left.addLast(right.removeFirst());
                    }
                    break;
                case "B":
                    if (!left.isEmpty()) {
                        left.removeLast();
                    }
                    break;
                case "P":
                    char ch = input[1].charAt(0);
                    left.addLast(ch);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : left) sb.append(c);
        for (char c : right) sb.append(c);
        System.out.println(sb);
    }
}
