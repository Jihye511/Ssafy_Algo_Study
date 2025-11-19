package 신승용.VER2.WEEK05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BOJ_14725 {
    static class Node {
        Map<String, Node> child = new HashMap<>();
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node root = new Node();

        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            int K = Integer.parseInt(tokens[0]);

            Node cur = root;
            for (int j = 1; j <= K; j++) {
                String token = tokens[j];
                cur.child.putIfAbsent(token, new Node());
                cur = cur.child.get(token);
            }
        }

        dfs(root, 0);
    }

    static void dfs(Node node , int depth){
        List<String> keys = new ArrayList<>(node.child.keySet());
        Collections.sort(keys);

        for (String key : keys) {
            Node child = node.child.get(key);

            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);

            dfs(child, depth+1);
        }
    }
}
