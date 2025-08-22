package WEEK07;

import java.io.*;
import java.util.*;

public class BOJ_16928 {

    static class Node implements Comparable<Node> {
        int location;
        int cnt;

        public Node() {}
        public Node(int location, int cnt) {
            this.location = location;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Node o) {
            if (this.cnt == o.cnt) {
                return Integer.compare(o.location, this.location);
            }

            return Integer.compare(this.cnt, o.cnt);
        }
    }

    static int N, M;
    static int[] radder, snake, dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        radder = new int[101];
        Arrays.fill(radder, -1);
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            radder[s] = e;
        }

        snake = new int[101];
        Arrays.fill(snake, -1);
        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            snake[s] = e;
        }

        dist = new int[101];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        dijkstra();

    }

    public static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            // 한 턴 안에 갈 수 있으면 +1턴으로 종료
            if (curr.location >= 94) {
                System.out.println(curr.cnt+1);
                return;
            }
            

            for (int i=1; i<=6; ++i) {
                int next = move(curr.location+i);
                if (next > 100) {
                    continue;
                }

                if (curr.cnt+1 < dist[next]) {
                    dist[next] = curr.cnt+1;
                    pq.add(new Node(next, curr.cnt + 1));
                }
            }
        }
    }

    public static int move(int x) {
        if (radder[x] != -1) {
            return radder[x];
        }

        if (snake[x] != -1) {
            return snake[x];
        }

        return x;
    }
}
