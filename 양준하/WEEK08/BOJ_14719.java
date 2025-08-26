import java.io.*;
import java.util.*;

public class BOJ_14719 {
    static int H, W;
    static int[] world;
    static int ans = 0;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        world = new int[W];
        pq = new PriorityQueue<>(Comparator.comparingInt((int[] block) -> block[1]).reversed());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < W; i++) {
            world[i] = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {i, world[i]});
        }
        
        while (pq.size() > 1) {
            int[] a = pq.poll();
            int[] b = pq.peek();
        
            int l = Math.min(a[0], b[0]);
            int r = Math.max(a[0], b[0]);
        
            for (int i = l + 1; i < r; i++) {
                int rain = b[1] - world[i];
                if (rain > 0) {
                    ans += rain;
                    world[i] = b[1];
                }
            }
        }
        System.out.println(ans);
    }
}
