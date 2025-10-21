import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String word;
        Map<String, Integer> word_map = new HashMap<>();
        for(int i = 0; i < N; i++){
            word = br.readLine();

            if(word.length() < M) continue;

            word_map.put(word, word_map.getOrDefault(word, 0) +1);
        }

        ArrayList<String> word_list = new ArrayList<>(word_map.keySet());
        Collections.sort(word_list, new Comparator<String> () {

            @Override
            public int compare(String o1, String o2){
                if(word_map.get(o1) != word_map.get(o2)){
                    return Integer.compare(word_map.get(o2), word_map.get(o1));
                }
                else if(o1.length() != o2.length()){
                    return o2.length() - o1.length();
                }
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s : word_list){
            sb.append(s + "\n");
        }
        System.out.println(sb);
    }
}
