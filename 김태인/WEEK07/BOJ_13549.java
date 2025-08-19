import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int pos, time;

        Node(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static int N, K;
    static int[] time;
    static final int MAX = 100001;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[MAX];
        Arrays.fill(time, INF);

        dijkstra();
        System.out.println(time[K]);
    }

    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(N, 0));
        time[N] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int nowPos = current.pos;
            int nowTime = current.time;

            if (nowTime > time[nowPos]) {
                continue;
            }

            int nextPos1 = nowPos * 2;
            if (nextPos1 < MAX && time[nextPos1] > nowTime) {
                time[nextPos1] = nowTime;
                pq.add(new Node(nextPos1, nowTime));
            }

            int nextPos2 = nowPos + 1;
            if (nextPos2 < MAX && time[nextPos2] > nowTime + 1) {
                time[nextPos2] = nowTime + 1;
                pq.add(new Node(nextPos2, nowTime + 1));
            }

            int nextPos3 = nowPos - 1;
            if (nextPos3 >= 0 && time[nextPos3] > nowTime + 1) {
                time[nextPos3] = nowTime + 1;
                pq.add(new Node(nextPos3, nowTime + 1));
            }
        }
    }
}
