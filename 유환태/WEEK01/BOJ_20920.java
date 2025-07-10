package boj;

import java.util.*;
import java.io.*;

public class Main20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        Map<String, Integer> words = new TreeMap<>();
        int N, M;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            String word = br.readLine();
            if(word.length()>=M) {
                words.put(word, words.getOrDefault(word, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(words.keySet());

        keySet.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(words.get(o1).equals(words.get(o2))) {
                    if(o1.length()==o2.length()) {
                        return o1.compareTo(o2);
                    }
                    return o2.length() - o1.length();
                }
                return words.get(o1).compareTo(words.get(o2)) * -1;
            }
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(String word : keySet){
            bw.write(word+"\n");
        }
        bw.close();
    }
}
