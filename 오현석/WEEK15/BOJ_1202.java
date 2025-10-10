import java.io.*;
import java.util.*;

public class Main {
    static class Jewel {
        int weight;
        int value;
        public Jewel(int w, int v) {
            this.weight = w;
            this.value = v;
        }
    }
    
    public static void main(String[] args) throws IOException {
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
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel o1, Jewel o2) {
                return Integer.compare(o1.weight, o2.weight);
            }
        });
        
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long result = 0L;
        int jewelIdx = 0;
        
        for (int i = 0; i < K; i++) {
            int capacity = bags[i];
            while (jewelIdx < N && jewels[jewelIdx].weight <= capacity) {
                pq.offer(jewels[jewelIdx].value);
                jewelIdx++;
            }
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }
        
        System.out.println(result);
    }
}
