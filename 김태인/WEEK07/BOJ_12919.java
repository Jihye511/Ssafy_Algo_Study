import java.util.*;
import java.io.*;

public class Main {

    static String start_word, end_word;
    static int start_len;
    static boolean result = false;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        start_word = br.readLine();
        end_word = br.readLine();
        start_len = start_word.length();
        dfs(end_word);
        System.out.println(result ? 1 : 0);
    }

    public static void dfs(String now){
        if(result) return;
        if (now.length() == start_len){
            if (now.equals(start_word)) result = true;
            return;
        }

        if (now.charAt(now.length() - 1) == 'A'){
            dfs(now.substring(0, now.length() - 1));
        }

        if (now.charAt(0) == 'B'){
            StringBuilder sb = new StringBuilder(now.substring(1));
            dfs(sb.reverse().toString());
        }

    }


}
