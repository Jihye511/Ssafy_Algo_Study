import java.util.*;
import java.io.*;

public class Main {
    static int[] prev = new int[100001]; 
    static int[] dist = new int[100001]; 
    static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        q.add(N);
        visited[N] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K) break;

            for (int next : new int[]{cur - 1, cur + 1, cur * 2}) {
                if (next < 0 || next > 100000 || visited[next]) continue;
                visited[next] = true;
                prev[next] = cur;
                dist[next] = dist[cur] + 1;
                q.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[K] + "\n");

        List<Integer> path = new ArrayList<>();
        for (int i = K; i != N; i = prev[i]) {
            path.add(i);
        }
        path.add(N);
        Collections.reverse(path);

        for (int p : path) {
            sb.append(p + " ");
        }
        
        System.out.println(sb.toString());
    }

}
