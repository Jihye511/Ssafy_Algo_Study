import java.util.*;
import java.io.*;

public class Boj_20437_문자열게임2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String input = br.readLine();
            int K = Integer.parseInt(br.readLine());

            int first = Integer.MAX_VALUE;
            int second = -1;

            ArrayList<Integer>[] index = new ArrayList[26];
            for (int i = 0; i < 26; i++) {
                index[i] = new ArrayList<>();
            }

            for (int i = 0; i < input.length(); i++) {
                int curr = input.charAt(i) - 'a';
                index[curr].add(i);
            }

            for (ArrayList ind : index) {
                if (ind.size() < K) continue;

                for (int start = 0; start + K -1 < ind.size(); start++) {
                    first = Math.min(first, (Integer) ind.get(start + K -1) - (Integer) ind.get(start) + 1);
                    second = Math.max(second, (Integer) ind.get(start + K -1) - (Integer) ind.get(start) + 1);
                }
            }

            if (first == Integer.MAX_VALUE) {
                System.out.println(-1);
                continue;
            }
            else {
                System.out.print(first + " ");
            }

            System.out.println(second);
        }
    }
}
