package Baekjoon.WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ_22233 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int s=0, e=0;
            for (char c : input.toCharArray()) {
                if (c == ',') {
                    String word = input.substring(s, e);
                    set.remove(word);
                    e++;
                    s = e;
                }
                else e++;
            }
            String word = input.substring(s, e);
            set.remove(word);

            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
