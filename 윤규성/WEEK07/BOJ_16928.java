import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q16928 {

    public static class Node {
        int x, time;
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ladders = new int[N][2];
        int[][] snakes = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ladders[i][0] = Integer.parseInt(st.nextToken());
            ladders[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            snakes[i][0] = Integer.parseInt(st.nextToken());
            snakes[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] time = new int[101];
        Arrays.fill(time, Integer.MAX_VALUE);

        ArrayDeque<Node> q = new ArrayDeque<>();
        q.add(new Node(1, 0));
        time[1] = 0;

        while (!q.isEmpty()) {
            Node now = q.poll();

            for (int w = 1; w <= 6; w++) {
                int next = now.x + w;
                if (next > 100) continue;

                for (int l = 0; l < N; l++) {
                    if (next == ladders[l][0]) {
                        next = ladders[l][1];
                        break;
                    }
                }
                for (int s = 0; s < M; s++) {
                    if (next == snakes[s][0]) {
                        next = snakes[s][1];
                        break;
                    }
                }

                if (time[next] > now.time + 1) {
                    time[next] = now.time + 1;
                    q.add(new Node(next, now.time + 1));
                }
            }
        }

        System.out.println(time[100]);
    }
}
