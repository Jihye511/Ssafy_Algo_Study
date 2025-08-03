import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String target = br.readLine();
        int[] targetCount = countAlpha(target);

        int answer = 0;

        for (int i = 0; i < N-1; i++) {
            String compare = br.readLine();
            int[] compareCount = countAlpha(compare);

            if (isSimilar(targetCount,compareCount)) answer++;
        }


        System.out.println(answer);
    }

    private static int[] countAlpha(String input) {
        int[] count = new int[26];
        for (char c : input.toCharArray()) {
            count[c - 'A']++;
        }

        return count;
    }

    private static boolean isSimilar(int[] target, int[] compare) {
        int diffCnt = 0;
        int plus = 0;
        int minus = 0;

        for (int i = 0; i < 26; i++) {
            int diff = target[i] - compare[i];
            if (diff != 0) diffCnt += Math.abs(diff);
            if (diff == 1) plus++;
            if (diff == -1) minus++;
        }
        

        return diffCnt <= 1 || (diffCnt == 2 && plus == 1 && minus == 1);
    }
}
