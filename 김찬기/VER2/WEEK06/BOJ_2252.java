package VER2.WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_2252 {

    static class Node {
        int n;
        int d;

        public Node(int n, int d) {
            this.n = n;
            this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<=N; ++i) {
            graph.add(new ArrayList<>());
        }

        int[] degree = new int[N+1];

        for (int i=0; i<M; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            ++degree[e];
            graph.get(s).add(e);
        }

        Queue<Integer> q = new ArrayDeque<>();
        for (int i=1; i<degree.length; ++i) {
            if (degree[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int curr = q.poll();
            sb.append(curr).append(" ");
            --degree[curr];

            for (int next : graph.get(curr)) {
                --degree[next];
                if (degree[next] == 0) {
                    q.add(next);
                }
            }
        }

        System.out.println(sb);
    }
}
