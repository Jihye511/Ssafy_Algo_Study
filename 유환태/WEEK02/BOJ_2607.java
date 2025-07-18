package boj;

import java.util.*;
import java.io.*;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        String first_word =  br.readLine();
        int[] first_alpha = new int[26];

        for (int i = 0; i < first_word.length(); i++) {
            first_alpha[first_word.charAt(i) - 'A']++;
        }

        for(int i = 0; i < N - 1; i++){
            String compare_word =  br.readLine();
            int[] compare_alpha = new int[26];

            for(int j = 0; j < compare_word.length(); j++){
                compare_alpha[compare_word.charAt(j) - 'A']++;
            }

            boolean isSame = true;
            int sum = 0;
            int cnt = 0;

            for(int j = 0; j < 26; j++){
                if(Math.abs(first_alpha[j] - compare_alpha[j]) > 1){
                    isSame = false;
                }else{
                    sum += (first_alpha[j] - compare_alpha[j]);
                    if(Math.abs(first_alpha[j] - compare_alpha[j]) == 1){
                        cnt++;
                    }
                }
            }


            if(isSame && (sum == 0 || sum == 1 || sum == -1)){
                if(cnt<3){
                    ans++;
                }
            }


        }
        System.out.println(ans);
    }

}

