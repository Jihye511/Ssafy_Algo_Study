package Baekjoon.WEEK14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {
    static int N, M;
    static class Jewel implements Comparable<Jewel> {
        int m, v;
        Jewel(int m, int v) {
            this.m = m;
            this.v = v;
        }
        public int compareTo(Jewel o) {
            return Integer.compare(this.m, o.m);
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long ans = 0;
        Jewel[] jewels = new Jewel[N];
        int[] bags = new int[M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i=0; i<M; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        int c=0;
        for (int i=0; i<M; i++) {
            while (c<N && jewels[c].m <= bags[i]) {
                que.add(jewels[c++].v);
            }
            if (!que.isEmpty())
                ans += que.poll();
        }

        System.out.println(ans);
    }
}
