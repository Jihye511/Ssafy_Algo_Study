import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        LinkedList<Character> editor = new LinkedList<>();
        for (char c : input.toCharArray()) {
            editor.add(c);
        }

        ListIterator<Character> cursor = editor.listIterator(editor.size());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            switch (command) {
                case 'L' : if (cursor.hasPrevious()) cursor.previous(); break;
                case 'D' : if (cursor.hasNext()) cursor.next(); break;
                case 'B' :
                    if (cursor.hasPrevious()) {
                        cursor.previous();
                        cursor.remove();
                    }
                    break;
                case 'P' :
                    char letter = st.nextToken().charAt(0);
                    cursor.add(letter);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : editor) {
            sb.append(c);
        }
        System.out.println(sb);
    }
}
