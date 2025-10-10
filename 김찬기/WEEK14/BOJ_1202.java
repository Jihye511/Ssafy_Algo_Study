package WEEK14;

import java.io.*;
import java.util.*;

public class BOJ_1202 {
    static class Jewel {
        int w;
        int p;

        public Jewel() {}
        public Jewel(int w, int p) {
            this.w = w;
            this.p = p;
        }
    }

    static List<Jewel> jewels;
    static TreeMap<Integer, Integer> bags;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수

        jewels = new ArrayList<>();
        bags = new TreeMap<>();

        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(w, p));
        }

        for (int i=0; i<K; ++i) {
            int w = Integer.parseInt(br.readLine());
            bags.put(w, bags.getOrDefault(w, 0)+1);
        }

        Collections.sort(jewels, (o1, o2) -> Integer.compare(o2.p, o1.p));

        long result = 0;
        for(Jewel jewel : jewels) {
            Integer idx = bags.ceilingKey(jewel.w);
            if (idx == null) {
                continue;
            }

            int cnt = bags.get(idx);
            if (cnt == 1) {
                bags.remove(idx);
            }
            else {
                bags.put(idx, cnt-1);
            }

            result += jewel.p;
        }

        System.out.println(result);
    }
}
