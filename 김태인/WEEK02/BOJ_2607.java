import java.io.*;
import java.util.*;

public class Main {

    static int N, result;
    static int[] word_arr = new int[26];
    static int[] temp_arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = 0;
        String word, temp;
        word = br.readLine();
        for (int i = 0; i < word.length(); i++) {
            word_arr[word.charAt(i) - 'A'] += 1;
        }

        int diff;
        for (int i = 0; i < N-1; i++) {
            temp = br.readLine();
            temp_arr = new int[26];
            diff = 0;

            for (int j = 0; j < temp.length(); j++) {
                temp_arr[temp.charAt(j) - 'A'] += 1;
            }

            for (int j = 0; j < 26; j++) {
                diff += Math.abs(word_arr[j] - temp_arr[j]);
            }

            if(diff == 0 || diff == 1 || (diff == 2 && temp.length() == word.length())){
                result ++;
            }

        }

        System.out.println(result);

    }

}
