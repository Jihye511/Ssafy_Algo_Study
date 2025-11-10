import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] prev = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        q.add(N);
        visited[N] = true;
        prev[N] = -1;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == K) {
                System.out.println(time[now]);

                ArrayList<Integer> path = new ArrayList<>();
                for (int i = now; i != -1; i = prev[i]) {
                    path.add(i);
                }
                Collections.reverse(path);
                for (int p : path) System.out.print(p + " ");
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > 100000 || visited[next]) continue;
                visited[next] = true;
                q.add(next);
                prev[next] = now;
                time[next] = time[now] + 1;
            }
        }
    }
}
