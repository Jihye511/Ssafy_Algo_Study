import java.util.*;
import java.io.*;

public class Boj_1522_문자열교환 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder sb = new StringBuilder(input);

        int aCnt = 0;
        int N = input.length();

        for (int i = 0; i < input.length(); i++) {
            if (sb.charAt(i) == 'a') aCnt++;
        }

        sb.append(input);

        char[] chars = sb.toString().toCharArray();

        if (aCnt == 0 || aCnt == N || aCnt == 1) {
            System.out.println(0);
            return;
        }

        int start = 0;
        int end;

        int ans = 0;
        for (end = 0; end < aCnt; end++) {
            if (chars[end] == 'b') ans++;
        }

        end = aCnt-1;
        int cnt = ans;
        while (end < N*2-1) {
            if (chars[start++] == 'b') cnt--;
            if (chars[++end] == 'b') cnt++;
            ans = Math.min(cnt,ans);
        }

        System.out.println(ans);

    }
}
