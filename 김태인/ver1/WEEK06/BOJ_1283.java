import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static HashSet<Character> set;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        set = new HashSet<>();
        sb = new StringBuilder();
        String temp;
        String total_word;
        for (int i = 0; i < N; i++) {
            total_word = br.readLine();
            if(first_check(total_word)){
                first_do(total_word);
            }
            else{
                second_do(total_word);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static boolean first_check(String words){
        StringTokenizer st = new StringTokenizer(words);
        while(st.hasMoreTokens()){
            String temp = st.nextToken();
            if(!set.contains(Character.toUpperCase(temp.charAt(0)))){

                return true;
            }
        }
        return false;
    }

    public static boolean second_check(String words){
        for(char alpha : words.toCharArray()){
            if(alpha == ' ') continue;
            if(!set.contains(alpha)) return true;
        }
        return false;
    }

    public static void first_do(String words){
        StringTokenizer st = new StringTokenizer(words);
        boolean flag = false;
        String temp;
        while(st.hasMoreTokens()){
            temp = st.nextToken();
            if(!flag && !set.contains(Character.toUpperCase(temp.charAt(0)))){
                set.add(Character.toUpperCase(temp.charAt(0)));
                sb.append("[").append(temp.charAt(0)).append("]");
                for (int j = 1; j < temp.length(); j++) {
                    sb.append(temp.charAt(j));
                }
                sb.append(" ");
                flag = true;
                continue;
            }
            sb.append(temp).append(" ");
        }

    }

    public static void second_do(String words){
        boolean flag = false;
        for(char alpha : words.toCharArray()){
            if(alpha == ' ') {
                sb.append(alpha);
                continue;
            }
            if(!flag && !set.contains(Character.toUpperCase(alpha))) {
                sb.append("[").append(alpha).append("]");
                set.add(Character.toUpperCase(alpha));
                flag = true;
                continue;
            }
            sb.append(alpha);
        }
    }

}
