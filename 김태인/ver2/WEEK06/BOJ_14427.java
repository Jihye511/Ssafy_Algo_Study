import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int val;
        int idx;
        Node(int v, int i) { val = v; idx = i; }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node a, Node b) {
                if (a.val != b.val) return Integer.compare(a.val, b.val);
                return Integer.compare(a.idx, b.idx);
            }
        });

        for (int i = 0; i < N; i++) pq.offer(new Node(arr[i], i));

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int q = 0; q < M; q++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int Ai = Integer.parseInt(st.nextToken()) - 1;
                int V = Integer.parseInt(st.nextToken());
                arr[Ai] = V;
                pq.offer(new Node(V, Ai));
            } else {

                while (true) {
                    Node top = pq.peek();
                    if (top == null) break;
                    if (arr[top.idx] == top.val) {
                        sb.append(top.idx + 1).append("\n");
                        break;
                    } else {
                        pq.poll();
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
