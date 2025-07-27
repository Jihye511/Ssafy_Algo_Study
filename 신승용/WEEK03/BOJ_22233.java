import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_22233 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            map.put(br.readLine(), 0);
        }

        int result = map.size();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String[] tokens = br.readLine().split(",");
            for (int j = 0; j < tokens.length; j++) {
                int count = map.getOrDefault(tokens[j], -1);
                if(count == 0){
                    map.put(tokens[j], map.get(tokens[j])+1);
                    result--;
                }
            }
            sb.append(Integer.toString(result));
            sb.append("\n");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
