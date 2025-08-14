import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static boolean[] visit;
    static int[] move = {1, -1, 2};
    static int MAX = 100001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[MAX];

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        visit[N] = true;
        int cnt = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(N);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == K) {
                    return cnt;
                }

                for (int j = 0; j < 3; j++) {
                    int pvt = (j == 2) ? current * move[j] : current + move[j];
                    if (pvt >= 0 && pvt < MAX && !visit[pvt]) {
                        visit[pvt] = true;
                        queue.offer(pvt);
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}