package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] numChar =  new int[26];
        int[] inputNumChar = new int[26];
        int count, sum, answer = 0;
        for (char c : br.readLine().toCharArray()) {
            numChar[c - 'A']++;
        }

        L:for (int i = 1; i < N; i++) {
            inputNumChar = new int[26];

            for (char c : br.readLine().toCharArray()) {
                inputNumChar[c - 'A']++;
            }

            count = 0;
            sum = 0;
            for (int j = 0; j<26; j++) {
                int sub = numChar[j]- inputNumChar[j];
                if (sub != 0) {
                    if (Math.abs(sub)>1) continue L;
                    count++;
                    sum+=sub;
                }
            }

            switch (count) {
                case 0:
                    answer ++;
                    break;
                case 1:
                    answer ++;
                    break;
                case 2: {
                    if (sum == 0) answer ++;
                    break;
                }
            }
        }
        System.out.println(answer);
    }
}