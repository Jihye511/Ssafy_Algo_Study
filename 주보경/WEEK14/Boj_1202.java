import java.io.*;
import java.util.*;

public class Boj_1202_보석도둑 {

    static class Jewel {
        int w;
        int v;

        public Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken());
        }

        //정렬
        Arrays.sort(jewels, Comparator.comparingInt(j -> j.w));
        Arrays.sort(bags);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        long answer = 0;
        int idx = 0;

        for (int cap : bags) {
            while (idx < N && jewels[idx].w <= cap) {
                maxHeap.add(jewels[idx].v);
                idx++;
            }
            if (!maxHeap.isEmpty()) {
                answer += maxHeap.poll();
            }
        }

        System.out.println(answer);
    }
}
