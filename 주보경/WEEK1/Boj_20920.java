import java.util.*;
import java.io.*;

public class Boj_20920_영단어암기는괴로워 {
    static class Word implements Comparable<Word> {
        String word;
        int freq;
        int length;

        public Word(String word, int freq) {
            this.word = word;
            this.freq = freq;
            this.length = word.length();
        }

        @Override
        public int compareTo(Word o) {
            if (this.freq != o.freq) {
                return o.freq - this.freq;
            }
            if (this.word.length() != o.word.length()) {
                return o.word.length() - this.word.length();
            }
            return this.word.compareTo(o.word);
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> wordFreq = new HashMap<>();


        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
            }
        }
        List<Word> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordFreq.entrySet()) {
            list.add(new Word(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (Word w : list) {
            bw.write(w.word);
            bw.newLine();
        }

        bw.flush();
    }
}
