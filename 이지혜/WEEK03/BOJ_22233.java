import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            map.put(br.readLine(), 1);
        }
        StringBuilder sb = new StringBuilder();
        int cnt=N;
        for(int i = 0; i < M; i++){
            String[] str = br.readLine().split(",");

            for(int j = 0; j < str.length; j++){
                if(map.containsKey(str[j])){
                    if(map.get(str[j]) > 1) continue;
                    else{
                        map.put(str[j], map.get(str[j]) + 1);
                        cnt--;
                    }

                }
            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
