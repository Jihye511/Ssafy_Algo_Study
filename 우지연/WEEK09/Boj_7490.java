import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // static int result;
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            recursive(1, N, 0, 1, "1");

            for (String s : list) {
                sb.append(s).append('\n');
            }
            if (i != T - 1) {
                sb.append('\n');
            }

           

        }
         System.out.print(sb);
    }

    public static void recursive(int i, int end, int sum, int last, String str) {

        if (i == end) {
            if (sum + last == 0) {
                list.add(str);

            }
            return;
        }
        int next = i + 1;

        int merge = 0;
        if (last >= 0) {
            merge = last * 10 + next;
        } else {
            merge = last * 10 - next;
        }
        recursive(next, end, sum, merge, str + " " + next);
        recursive(next, end, sum + last, +next, str + "+" + next);
        recursive(next, end, sum + last, -next, str + "-" + next);

    }
}
