import java.util.*;
import java.io.*;

public class Main {

    static String word;
    static String obj;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        word = br.readLine();
        obj = br.readLine();

        StringBuilder sb = new StringBuilder();
        int obj_len = obj.length();

        for (int i = 0; i < word.length(); i++) {
            sb.append(word.charAt(i));

            if(sb.length() >= obj_len){
                boolean flag = true;
                for (int j = 0; j < obj_len; j++) {
                    if(sb.charAt(sb.length() - obj_len + j) != obj.charAt(j)){
                        flag = false;
                    }
                }
                if(flag){
                    sb.delete(sb.length() - obj_len, sb.length());
                }
            }

        }

        if(sb.length() == 0) System.out.println("FRULA");
        else System.out.println(sb);


    }
}
