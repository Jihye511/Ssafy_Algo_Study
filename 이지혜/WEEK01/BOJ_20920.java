import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();

        int N, M;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() >= M) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(
                Comparator.comparing(Map.Entry<String,Integer>::getValue,Comparator.reverseOrder())
                                .thenComparing(e -> e.getKey().length(),Comparator.reverseOrder())
                                        .thenComparing(Map.Entry::getKey)
        );
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : list){
            sb.append(entry.getKey()).append("\n");
        }
        System.out.println(sb);
    }
}
