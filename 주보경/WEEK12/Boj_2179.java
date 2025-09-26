import java.util.*;
import java.io.*;

public class Boj_2179_비슷한단어 {
    static class Word {
        String str;
        int originalIdx;

        public Word(String str, int originalIdx) {
            this.str = str;
            this.originalIdx = originalIdx;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Word> list = new ArrayList<>();
        String[] original = new String[N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            list.add(new Word(s, i));
            original[i] = s;
        }

        list.sort(Comparator.comparing(w -> w.str));

        int max = -1;
        ArrayList<Word[]> ele = new ArrayList<>(); //후보저장
        for (int i = 0; i < N; i++) {
            for (int nxt = i+1; nxt < N; nxt++) {
                int temp = 0;
                for (int j = 0; j < Math.min(list.get(i).str.length(), list.get(nxt).str.length()); j++) {
                    if (list.get(i).str.charAt(j) != list.get(nxt).str.charAt(j)) {
                        break;
                    }
                    temp++;
                }
                if (temp == max) {
                    ele.add(new Word[] {list.get(i),list.get(nxt)});
                }

                if (temp > max) {
                    max = temp;
                    ele = new ArrayList<>();
                    ele.add(new Word[] {list.get(i),list.get(nxt)});
                }
            }
            

        }

        //후보 내에서 비교하기
        int S = Integer.MAX_VALUE;
        int T = Integer.MAX_VALUE;

        for (Word[] e : ele) {
            int min = Math.min(e[0].originalIdx, e[1].originalIdx);
            int last = Math.max(e[0].originalIdx, e[1].originalIdx);

            if (min < S || min == S && last < T) {
                S = min;
                T = last;
            }
        }

        System.out.println(original[S]);
        System.out.println(original[T]);

    }
}
