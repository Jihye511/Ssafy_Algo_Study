package Baekjoon.WEEK3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_19637 {
    static class Node implements Comparable<Node>{
        int score;
        String style;

        Node(int score, String style) {
            this.score = score;
            this.style = style;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.score, o.score);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        TreeSet<Node> set = new TreeSet<Node>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String style = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            Node node = new Node(score, style);

            if (set.contains(node)) continue;

            set.add(node);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int score = Integer.parseInt(st.nextToken());

            Node node = set.ceiling(new Node(score, ""));
            if (node == null) {
                sb.append(set.first().style);
                sb.append("\n");
            }
            else {
                sb.append(node.style);
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}