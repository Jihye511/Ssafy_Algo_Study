import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_20920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String input;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i=0; i<N; i++) {
            input = br.readLine();

            if (input.length() < M) continue;
            if (map.get(input) == null) {
                map.put(input, 1);
            }
            else {
                map.put(input, map.get(input)+1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> que = new PriorityQueue<>(
                (a, b) -> {
                    if (a.getValue().equals(b.getValue())) {
                        if (a.getKey().length() != b.getKey().length()) {
                            return b.getKey().length() - a.getKey().length();
                        }
                        else return a.getKey().compareTo(b.getKey());

                    }
                    return b.getValue() - a.getValue();
                });

        que.addAll(map.entrySet());

        while(!que.isEmpty()) {
            sb.append(que.poll().getKey()+"\n");
        }

        System.out.println(sb.toString());
    }
}
