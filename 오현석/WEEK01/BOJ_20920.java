import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        HashMap<String,Integer> hmap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if(word.length()<L)continue;
            hmap.put(word,hmap.getOrDefault(word,0)+1);
        }
        List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(hmap.entrySet());
        sortedList.sort((a, b) ->{
            int freqA = a.getValue();
            int freqB = b.getValue();

            if (freqA != freqB) return freqB - freqA; // 빈도 내림차순
            if (a.getKey().length() != b.getKey().length()) return b.getKey().length() - a.getKey().length(); // 길이 내림차순
            return a.getKey().compareTo(b.getKey()); // 알파벳 사전순
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedList) {
            sb.append(entry.getKey());
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
