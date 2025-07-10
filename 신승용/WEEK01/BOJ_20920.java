package 신승용.WEEK01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_20920 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String token = br.readLine();
            if(token.length() >= M){
                map.put(token, map.getOrDefault(token, 0)+1);
            }
        }

        List<String> keyList = new ArrayList<>(map.keySet());

        keyList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(map.get(o1)!=map.get(o2)){
                    return -1 * Integer.compare(map.get(o1), map.get(o2));
                } else if(o1.length() != o2.length()){
                    return -1 * Integer.compare(o1.length(), o2.length());
                } else {
                    for (int i = 0; i < o1.length(); i++) {
                        if(o1.charAt(i) != o2.charAt(i)){
                            return o1.compareTo(o2);
                        }
                    }
                }
                return 0;
            };
        });

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < keyList.size(); i++) {
            bw.append(keyList.get(i));
            bw.append("\n");
        }
        
        bw.flush();
        bw.close();
    }
}