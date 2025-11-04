package VER2.WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_15961 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i=0; i<N; ++i) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        boolean coupon = false;
        int result = 0;
        for (int i=0; i<k; ++i) {
            cnt.put(sushi[i], cnt.getOrDefault(sushi[i], 0)+1);
            if (sushi[i] == c) {
                coupon = true;
            }
        }

        for (int i=0; i<N; ++i) {
            int idx = (i+k) % N;
            cnt.put(sushi[i], cnt.get(sushi[i])-1);

            cnt.put(sushi[idx], cnt.getOrDefault(sushi[idx], 0)+1);
            if (sushi[idx] == c) {
                coupon = true;
            }

            if (cnt.get(sushi[i]) == 0) {
                if (sushi[i] == c) {
                    coupon = false;
                }
                cnt.remove(sushi[i]);
            }

            if (coupon) {
                result = Math.max(result, cnt.size());
            }
            else {
                result = Math.max(result, cnt.size()+1);
            }
        }

        System.out.println(result);
    }
}
