import java.io.*;
import java.util.*;

public class Q2668 {

    static int N;
    static int[] f;
    static boolean[] visited, finished, inCycle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        f = new int[N + 1];
        for (int i = 1; i <= N; i++) f[i] = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        inCycle = new boolean[N + 1];

        for (int i = 1; i <= N; i++) if (!visited[i]) dfs(i);

        StringBuilder sb = new StringBuilder();
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= N; i++) if (inCycle[i]) ans.add(i);

        sb.append(ans.size()).append('\n');
        for (int x : ans) sb.append(x).append('\n');
        System.out.print(sb.toString());
    }

    static void dfs(int u) {
        visited[u] = true;
        int v = f[u];

        if (!visited[v]) {
            dfs(v);
        } else if (!finished[v]) {
            int cur = v;
            do {
                inCycle[cur] = true;
                cur = f[cur];
            } while (cur != v);
        }
        finished[u] = true;
    }
}
