import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String base = br.readLine();
        int[] baseAlpha = new int[26];
        for (char c : base.toCharArray()) baseAlpha[c - 'A']++;
        
        int ans = 0;
        for (int i = 1; i < N; i++) {
            String word = br.readLine();
            int[] curAlpha = new int[26];
            for (char c : word.toCharArray()) curAlpha[c - 'A']++;

            if (isSimilar(baseAlpha, base.length(), curAlpha, word.length())) {
                ans++;
            }
        }

        System.out.println(ans);
    }

    public static boolean isSimilar(int[] baseAlpha, int baseLen, int[] curAlpha, int curLen) {
        int diff = 0;

        for (int i = 0; i < 26; i++) {
            diff += Math.abs(baseAlpha[i] - curAlpha[i]);
        }

        if (diff == 0 || diff == 1) return true; // same or one added or removed
        if (diff == 2 && baseLen == curLen) return true; // one changed
        return false;
    }
}
