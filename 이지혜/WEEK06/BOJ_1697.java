import java.io.*;
import java.util.*;

public class Main {

    static final int MAX = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        if (n >= k) {
            System.out.println(n - k);
            return;
        }

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(n);
        dist[n] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == k) {
                System.out.println(dist[cur]);
                return;
            }
            int next;

            next = cur - 1;
            if (next >= 0 && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            }

            next = cur + 1;
            if (next <= MAX && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            }

            next = cur * 2;
            if (next <= MAX && dist[next] == -1) {
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }
    }
}
