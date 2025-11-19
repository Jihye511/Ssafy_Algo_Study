package boj;

import java.util.*;
import java.io.*;

public class BOJ_14725 {
    static class Tree{
        Map<String, Tree> child = new HashMap<>();

        public void insert(String s){
            Tree tree = this;
            String[] strs = s.split(" ");
            for(String str : strs){
                tree.child.putIfAbsent(str, new Tree());
                tree = tree.child.get(str);
            }
        }

        public void print(Tree tree, int depth) {
             if(tree.child != null){
                 List<String> list = new ArrayList<>(tree.child.keySet());
                 Collections.sort(list);
                 for(String str: list){
                     for(int d = 0; d < depth; d++){
                         System.out.print("--");
                     }
                     System.out.println(str);
                     print(tree.child.get(str),depth+1);
                 }
             }

        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());

        Tree tree = new Tree();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            StringBuilder insert = new StringBuilder();
            for(int j = 0; j < K; j++){
                insert.append(st.nextToken()).append(" ");
            }
            tree.insert(String.valueOf(insert));
        }

        tree.print(tree, 0);
    }
}
