import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        String now;
        ArrayList<Node> next;
        Node(String now) {
            this.now = now;
            this.next = new ArrayList<>();
        }
    }

    static int N;
    static ArrayList<Node> root;
    static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        root = new ArrayList<>();
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            Node prev = null;
            for (int depth = 0; depth < K; depth++) {
                String str = st.nextToken();

                if (depth == 0) {
                    Node node = null;
                    for (Node first : root) {
                        if (first.now.equals(str)) {
                            node = first;
                            break;
                        }
                    }
                    if (node == null) {
                        node = new Node(str);
                        root.add(node);
                    }
                    prev = node;
                }
                else {
                    Node child = null;
                    for (Node n : prev.next) {
                        if (n.now.equals(str)) {
                            child = n;
                            break;
                        }
                    }
                    if (child == null) {
                        child = new Node(str);
                        prev.next.add(child);
                    }
                    prev = child;
                }
            }
        }

        root.sort(Comparator.comparing(n -> n.now));

        for (Node r : root) {
            sortChildren(r);
        }

        for (Node r : root) {
            dfs(r, 0);
        }

        System.out.print(sb.toString());
    }

    static void sortChildren(Node node) {
        node.next.sort(Comparator.comparing(n -> n.now));
        for (Node child : node.next) {
            sortChildren(child);
        }
    }

    static void dfs(Node node, int depth) {
        for (int i = 0; i < depth; i++) {
            sb.append("--");
        }
        sb.append(node.now).append("\n");
        for (Node child : node.next) {
            dfs(child, depth + 1);
        }
    }
}
