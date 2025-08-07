package 신승용.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class BOJ_20922 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int left = 0;

        for (int i = 0; i < N; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
            if(map.get(arr[i]) > K){
                while (map.get(arr[i]) > K) {
                    map.put(arr[left], map.get(arr[left])-1);
                    left++;
                }
            }
            int len = i - left + 1;
            answer = Math.max(answer, len);
        }

        System.out.println(answer);
    }
}
/**
 * 9 2
 * 3 2 5 5 6 4 4 5 7
 * 
 * 
 * 7
 */