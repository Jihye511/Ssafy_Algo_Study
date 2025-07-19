import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BOJ_2607 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        String flat = br.readLine();
        Map<Character, Integer> flatMap = new HashMap<>();
        for (int i = 0; i < flat.length(); i++) {
            flatMap.put(flat.charAt(i), flatMap.getOrDefault(flat.charAt(i), 0)+1);
        }

        for (int i = 0; i < N-1; i++) {
            String token = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int j = 0; j < token.length(); j++) {
                map.put(token.charAt(j), map.getOrDefault(token.charAt(j), 0)+1);
            }
            Set<Character> set = new HashSet<>();
            set.addAll(flatMap.keySet());
            set.addAll(map.keySet());

            int flatBig = 0;
            int flatSmall = 0;
            boolean flag = true;

            for (Character c : set) {
                int diff = flatMap.getOrDefault(c, 0) - map.getOrDefault(c, 0);
                if(diff>0) flatBig += diff;
                else if(diff<0) flatSmall += -diff;
                if(flatBig > 2 || flatSmall > 2) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                int lenDiff = flat.length() - token.length();
                // 교체
                if (lenDiff == 0) {
                    flag = (flatBig == 0 && flatSmall == 0) || (flatBig == 1 && flatSmall == 1);
                } else if (lenDiff == 1) {
                // 추가
                    flag = (flatBig == 1 && flatSmall == 0);
                } else if (lenDiff == -1) {
                // 삭제
                    flag = (flatBig == 0 && flatSmall == 1);  
                } else {
                    flag = false;
                }
            }

            if(flag) answer++;
        }

        System.out.println(answer);
    }
}
