import java.io.*;
import java.util.*;

public class Q1283 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        // 선택된 위치를 저장 (-1: 선택 없음)
        int[] selectedIdx = new int[N];
        Arrays.fill(selectedIdx, -1);

        // 대소문자 무시를 위해 모두 소문자로 보관
        HashSet<Character> used = new HashSet<>();

        String[] strArr = new String[N];

        A: for (int i = 0; i < N; i++) {
            String str = br.readLine();
            strArr[i] = str;

            // 1단계: 각 "단어의 첫 글자"를 왼쪽→오른쪽으로 검사
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                // 단어의 첫 글자 조건: j==0 이거나 바로 앞이 공백
                if (c != ' ' && (j == 0 || str.charAt(j - 1) == ' ')) {
                    char key = Character.toLowerCase(c);
                    if (!used.contains(key)) {
                        used.add(key);
                        selectedIdx[i] = j; // 인덱스 저장!
                        continue A;
                    }
                }
            }

            // 2단계: 전체 문자에서 왼쪽→오른쪽으로 첫 사용 가능한 글자 탐색(공백은 건너뜀)
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == ' ') continue;

                char key = Character.toLowerCase(c);
                if (!used.contains(key)) {
                    used.add(key);
                    selectedIdx[i] = j; // 인덱스 저장!
                    continue A;
                }
            }
            // 선택 불가 시 그대로 둠(selectedIdx[i] == -1)
        }

        // 출력: 선택된 "인덱스"에만 괄호 처리
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < N; i++) {
            String s = strArr[i];
            int pick = selectedIdx[i];
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if (j == pick) {
                    line.append('[').append(s.charAt(j)).append(']');
                } else {
                    line.append(s.charAt(j));
                }
            }
            out.append(line).append('\n');
        }

        System.out.print(out);
    }
}
