package 신승용.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1522 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String token = br.readLine();

        int window = 0;
        int count = 0;
        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < token.length(); i++) {
            if(token.charAt(i)=='a'){
                window++;
            }
        }

        token += token;

        for (int i = 0; i < window; i++) {
            if(token.charAt(i)=='b'){
                count++;
            }
        }

        answer = count;

        for (int i = window; i < token.length()/2 + window; i++) {
            if(token.charAt(i-window)=='b'){
                count--;
            }
            if(token.charAt(i)=='b'){
                count++;
            }

            answer = Math.min(answer, count);
        }

        System.out.println(answer);
    }
}
