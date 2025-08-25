import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String word = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int[] result = execute(word, K);

            if (result[0] == Integer.MAX_VALUE) sb.append(-1).append("\n");
            else sb.append(result[0]).append(" ").append(result[1]).append("\n");
        }

        System.out.println(sb);
    }

    public static int[] execute(String word, int K) {
        List<Integer>[] pos = new ArrayList[26];
        for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            pos[word.charAt(i) - 'a'].add(i);
        }

        int shortest = Integer.MAX_VALUE;
        int longest = 0;

        for (int c = 0; c < 26; c++) {
            if (pos[c].size() < K) continue;
            List<Integer> list = pos[c];

            for (int i = 0; i <= list.size() - K; i++) {
                int len = list.get(i + K - 1) - list.get(i) + 1;
                shortest = Math.min(shortest, len);
                longest = Math.max(longest, len);
            }
        }

        return new int[]{shortest, longest};
    }
}
