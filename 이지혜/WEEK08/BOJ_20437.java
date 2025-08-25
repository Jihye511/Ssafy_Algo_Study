import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String s = br.readLine();
            int K = Integer.parseInt(br.readLine());

            // 각 문자별 등장 위치 저장
            List<Integer>[] pos = new ArrayList[26];
            for (int i = 0; i < 26; i++) pos[i] = new ArrayList<>();

            for (int i = 0; i < s.length(); i++) {
                pos[s.charAt(i) - 'a'].add(i);
            }

            int minLen = Integer.MAX_VALUE;
            int maxLen = -1;

            // 각 알파벳에 K개를 포함하는 모든 윈도우 길이를 계산
            for (int c = 0; c < 26; c++) {
                List<Integer> list = pos[c];
                if (list.size() < K) continue;

                for (int i = 0; i + K - 1 < list.size(); i++) {
                    int len = list.get(i + K - 1) - list.get(i) + 1;
                    if (len < minLen) minLen = len;
                    if (len > maxLen) maxLen = len;
                }
            }

            if (maxLen == -1) {
                sb.append(-1).append('\n');
            } else {
                sb.append(minLen).append(' ').append(maxLen).append('\n');
            }
        }

        System.out.print(sb);
    }
}
