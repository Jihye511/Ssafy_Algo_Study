import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17484 {
    private static class Node {
        int direction;
        int before;
        int cost;
        int step;
        public Node(int direction, int cost, int step, int before) {
            this.direction = direction;
            this.cost = cost;
            this.step = step;
            this.before = before;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        int[][] roads = new int[N][M];

        for (int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                roads[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int minCost = Integer.MAX_VALUE;

        Queue<Node> queue = new LinkedList<Node>();
        for (int i=0; i<M; i++) {
            for (int j=-1; j<=1; j++) {
                queue.add(new Node(j,roads[0][i], 1, i));
            }
        }

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.step == N) {
                minCost = Math.min(minCost, cur.cost);
                continue;
            }
            int next = cur.before + cur.direction;

            if (next >=0 && next <M) {
                for (int i=-1; i<=1; i++) {
                    if (i==cur.direction) continue;
                    queue.add(new Node(i, cur.cost+roads[cur.step][next], cur.step+1, next));
                }
            }
        }

        System.out.println(minCost);
    }
}
