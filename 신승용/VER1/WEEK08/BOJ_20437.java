package 신승용.WEEK08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_20437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String W = br.readLine();
            int K = Integer.parseInt(br.readLine());

            Map<Character, Integer> map = new HashMap<>();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < W.length(); i++) {
                map.put(W.charAt(i), map.getOrDefault(W.charAt(i), 0)+1);
            }

            List<Character> list = new ArrayList<>();
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() >= K){
                    list.add(entry.getKey());
                }
            }

            for (Character c : list) {
                List<Integer> arr = new ArrayList<>();
                for (int i = 0; i < W.length(); i++) {
                    if(W.charAt(i) == c){
                        arr.add(i);
                    }
                }

                int window = 0;

                window = arr.get(K-1) - arr.get(0)+1;

                min = Math.min(min, window);
                max = Math.max(max, window);
                
                for (int i = K; i < arr.size(); i++) {
                    window = arr.get(i) - arr.get(i-K+1)+1;

                    min = Math.min(min, window);
                    max = Math.max(max, window);
                }
            }

            if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
                System.out.println(-1);
            } else {
                System.out.println(min + " " + max);
            }

        }
    }
}
/**
 * 0 2 3 4 6
 */
