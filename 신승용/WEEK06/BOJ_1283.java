package 신승용.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1283 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String token = br.readLine();
            int put = -1;
            for (int j=0; j < token.length(); j++) {
                char c = token.charAt(j);
                if(j==0 || token.charAt(j-1)==' '){
                    if(!set.contains(Character.toUpperCase(c)) && ((c >= 'a' && c <= 'z') ||  
                    c >= 'A' && c <= 'Z')){
                        set.add(Character.toUpperCase(c));
                        put = j;
                        break;
                    }
                }
            }

            if(put < 0){
                for (int j=0; j < token.length(); j++) {
                    char c = token.charAt(j);
                    if(!set.contains(Character.toUpperCase(c)) && ((c >= 'a' && c <= 'z') ||  
                    c >= 'A' && c <= 'Z')){
                        set.add(Character.toUpperCase(c));
                        put = j;
                        break;
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < token.length(); j++) {
                char c = token.charAt(j);
                if (j == put) {
                    sb.append('[');
                }

                sb.append(c);

                if (j == put) {
                    sb.append(']');
                }
            }

            System.out.println(sb.toString());
        }
    }
}
