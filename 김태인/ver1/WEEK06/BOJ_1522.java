import java.util.*;
import java.io.*;

public class Main {

    static String word;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        int len = word.length();
        int a_cnt = 0;
        for (int i = 0; i < len; i++) {
            if(word.charAt(i) == 'a') a_cnt++;
        }

        for (int i = 0; i < len; i++) {
            int b_cnt = 0;
            for (int j = 0; j < a_cnt; j++) {
                if(word.charAt((i+j) % len) == 'b') b_cnt++;
            }
            result = Math.min(b_cnt, result);

        }

        System.out.println(result);

    }


}
