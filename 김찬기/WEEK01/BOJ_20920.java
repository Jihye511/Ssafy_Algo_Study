package WEEK01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {

    static class Word implements Comparable<Word> {
        String str;
        int count;

        @Override
        public int compareTo(Word o) {
            if (this.count == o.count) {
                if (this.str.length() == o.str.length()) {
                    return this.str.compareTo(o.str);
                }

                return Integer.compare(o.str.length(), this.str.length());
            }

            return Integer.compare(o.count, this.count);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Word> wordMap = new HashMap<>();

        for (int i=0; i<N; ++i) {
            String s = br.readLine();
            if (s.length() < M) {
                continue;
            }

            if (wordMap.containsKey(s)) {
                ++wordMap.get(s).count;
            }
            else {
                Word w = new Word();
                w.str = s;
                w.count = 1;
                wordMap.put(s, w);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for (String key : wordMap.keySet()) {
            wordList.add(wordMap.get(key));
        }

        Collections.sort(wordList);
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<wordList.size(); ++i) {
            sb.append(wordList.get(i).str).append("\n");
//            System.out.println(wordList.get(i).str);
        }

        System.out.println(sb);
    }
}
