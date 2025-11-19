package Baekjoon.VER2.WEEK5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_14725 {

    static class Node {
        String str;
        TreeMap<String, Node> map;
        StringBuilder sb;

        Node() {
            map = new TreeMap<>();
            sb = new StringBuilder();
        }

        Node(String str, StringBuilder sb) {
            this.str = str;
            map = new TreeMap<>();
            this.sb = sb;
        }

        public Node add(String str) {
            Node ret = map.get(str);
            if (ret==null) {
                ret = new Node(str, sb);
                map.put(str, ret);
                return ret;
            }
            else {
                return ret;
            }
        }

        public String toString() {
            for (String key: map.keySet()) {
                sb.append(key);
                map.get(key).toString(0);
            }
            return sb.toString();
        }

        private void toString(int c) {
            sb.append('\n');
            for (String key: map.keySet()) {
                for (int i=0; i<=c; i++) {
                    sb.append("--");
                }
                sb.append(key);
                map.get(key).toString(c+1);
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), c=0, M;
        StringTokenizer st;
        Integer n;
        String in;
        Node head = new Node();
        for (int i =0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            Node tmp = head;
            for (int j=0; j<M; j++) {
                tmp = tmp.add(st.nextToken());

            }
        }

        System.out.println(head);
    }
}
