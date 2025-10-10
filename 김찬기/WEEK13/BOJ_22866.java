package WEEK13;

import java.io.*;
import java.util.*;

public class BOJ_22866 {

    static class Top {
        int n;
        int h;

        public Top() {}
        public Top(int n, int h) {
            this.n = n;
            this.h = h;
        }
    }

    static class Node {
        int cnt;
        int near;
        int length = Integer.MAX_VALUE;

        Node() {}
        Node(int cnt, int near) {
            this.cnt = cnt;
            this.near = near;
        }

        @Override
        public String toString() {
            if (cnt == 0) {
                return "0";
            }
            else {
                return cnt + " " + near;
            }
        }
    }

    static int N;
    static List<Top> tops;
    static List<Node> result;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tops = new ArrayList<>();
        result = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        tops.add(new Top());
        result.add(new Node());
        for (int i=0; i<N; ++i) {
            tops.add(new Top(i+1, Integer.parseInt(st.nextToken())));
            result.add(new Node());
        }


        Deque<Top> stack = new ArrayDeque<>();
        for (int i=1; i<=N; ++i) {
            while (!stack.isEmpty() && stack.peek().h <= tops.get(i).h) {
                stack.pop();
            }

            Node curr = result.get(i);
            curr.cnt += stack.size();
            if (!stack.isEmpty()) {
                int gap = Math.abs(stack.peek().n - i);
                if (gap < curr.length) {
                    curr.near = stack.peek().n;
                    curr.length = gap;
                }
                else if (gap == curr.length && stack.peek().n < curr.near) {
                    curr.near = stack.peek().n;
                }
            }


            stack.push(tops.get(i));
        }

        stack = new ArrayDeque<>();
        for (int i=N; i>0; --i) {
            while (!stack.isEmpty() && stack.peek().h <= tops.get(i).h) {
                stack.pop();
            }

            Node curr = result.get(i);
            curr.cnt += stack.size();
            if (!stack.isEmpty()) {
                int gap = Math.abs(stack.peek().n - i);
                if (gap < curr.length) {
                    curr.near = stack.peek().n;
                    curr.length = gap;
                }
                else if (gap == curr.length && stack.peek().n < curr.near) {
                    curr.near = stack.peek().n;
                }
            }

            stack.push(tops.get(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i=1; i<=N; ++i) {
            sb.append(result.get(i).toString()).append("\n");
        }

        System.out.println(sb);
    }
}
