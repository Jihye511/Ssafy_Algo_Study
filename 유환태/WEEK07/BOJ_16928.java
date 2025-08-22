import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] move = new int[101]; 
        for (int i = 1; i <= 100; i++) move[i] = i;

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            move[start] = end;
        }

        boolean[] visited = new boolean[101];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int cnt = cur[1];

            if (pos == 100) { 
                System.out.println(cnt);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = pos + dice;
                if (next > 100) continue;
                next = move[next];

                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, cnt + 1});
                }
            }
        }
    }
}
