package WEEK07;

import java.io.*;
import java.util.*;

public class BOJ_13549 {

    static class Node {
        int x;
        int time;

        public Node() {}
        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }

    static int N, K;
    static int[] dist = new int[1000001];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra();

    }

    public static void dijkstra() {
        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.time, o2.time));
        pq.add(new Node(N, 0));
        dist[N] = 0;
        if (isValid(2*N)) {
            dist[2 * N] = 0;
            pq.add(new Node(2*N, 0));
        }

        while (!pq.isEmpty()) {
            Node curr = pq.poll();


            if (curr.x == K) {
                System.out.println(curr.time);
                return;
            }

            if (isValid(curr.x+1) && curr.time+1 < dist[curr.x+1]) {
                dist[curr.x+1] = curr.time+1;
                pq.add(new Node(curr.x+1, curr.time+1));
            }

            if (isValid(curr.x-1) && curr.time+1 < dist[curr.x-1]) {
                dist[curr.x-1] = curr.time+1;
                pq.add(new Node(curr.x-1, curr.time+1));
            }

            if (isValid(curr.x*2) && curr.time < dist[curr.x*2]) {
                dist[curr.x*2] = curr.time+1;
                pq.add(new Node(curr.x*2, curr.time));
            }
        }
    }

    public static boolean isValid(int x) {
        return x >= 0 && x < dist.length;
    }
}
