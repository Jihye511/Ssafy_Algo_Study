import java.io.*;
import java.util.*;

public class BOJ_1202 {
    static int N, K;
    static Jewel[] jewels;
    static int[] bags;

    static class Jewel {
        int m, v;
        Jewel(int m, int v) { 
            this.m = m; 
            this.v = v; 
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels, Comparator.comparingInt(j -> j.m));
        Arrays.sort(bags);

        PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparingInt(j -> -j.v));
        long ans = 0;
        int k = 0;

        for (int bag : bags) {
            while (k < N && jewels[k].m <= bag) {
                pq.offer(jewels[k]);
                k += 1;
            }
            if (!pq.isEmpty()) {
                ans += pq.poll().v;
            }
        }

        System.out.println(ans);
    }
}
