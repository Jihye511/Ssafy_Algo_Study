package boj;

import java.sql.Array;
import java.util.*;
import java.io.*;

public class BOJ_1202 {
    static class Jewel implements Comparable<Jewel>{
        int m;
        int v;
        Jewel(int m, int v){
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewel o) {
            if(this.m == o.m){
                return o.v - this.v;
            }
            return this.m - o.m;

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Jewel> jewels = new ArrayList<>();
        List<Integer> bags = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        for(int i = 0; i < K; i++){
            bags.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(jewels);
        Collections.sort(bags);
        long ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int idx = 0;
        for(int i = 0; i < K; i++){
            while(idx < N && jewels.get(idx).m <= bags.get(i)){
                pq.add(jewels.get(idx).v);
                idx++;
            }

            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }


        System.out.println(ans);

    }
}
