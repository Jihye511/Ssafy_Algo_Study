package Baekjoon.WEEK7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_13549 {
    static class Node implements Comparable<Node> {
        int p, t;
        Node (int p) {
            this.p = p;
            this.t = 0;
        }
        Node (int p, int t) {
            this.p = p;
            this.t = t;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.t, o.t);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);
    }

    static void bfs(int N, int K) {
        int[] arr = new int[100001];
        Arrays.fill(arr, Integer.MAX_VALUE);
        PriorityQueue<Node> que = new PriorityQueue<>();

        que.add(new Node(N));
        arr[N] = 0;
        while(!que.isEmpty()) {
            Node cur = que.poll();
            if (cur.p == K) {
                System.out.println(cur.t);
                return;
            }
            int nl = cur.p-1, nr = cur.p+1, nt = cur.p*2;

            if (nl>=0&&arr[nl]>cur.t+1) {
                System.out.println(cur.p+"-1");
                que.add(new Node(nl, cur.t+1));
                arr[nl] = cur.t+1;
            }
            if (nr<=100000&&arr[nr]>cur.t+1) {
                System.out.println(cur.p+"+1");
                que.add(new Node(nr, cur.t+1));
                arr[nr] = cur.t+1;
            }
            if (nt<=100000&&arr[nt]>cur.t) {
                if (nt>K) {
                    que.add(new Node(K, cur.t+(nt-K)));
                }
                else {
                    que.add(new Node(nt, cur.t));
                    arr[nt] = cur.t;
                }
            }
        }
    }
}
