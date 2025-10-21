package Baekjoon.WEEK4;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1406 {
    static class Node {
        char c;
        Node r, l;

        Node(char c) {
            this.c = c;
        }

        public void L(Node l) {
            if (this.l == null) {
                this.l = l;
                this.l.r = this;
            }
            else {
                this.l.r = l;
                l.l = this.l;
                l.r = this;
                this.l = l;

            }
        }
    }
    public static void main(String[] args) throws Exception{
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        Node node = new Node('\n');
        Node end = node;
        int curser = 0;
        int b;
        char command = ' ', input = ' ';
        while ((b = in.read()) != -1) {
            if (b == '\n') break;
            node.L(new Node((char) b));
            curser++;
        }

        while ((b = in.read()) != -1) {
            if (b == '\n') break;
            sb.append((char) b);
        }

        int N = Integer.parseInt(sb.toString());

        sb = new StringBuilder();

        for (int i=0; i<N; i++) {
            while ((b = in.read()) != -1) {
                if (b == '\n' || b == ' ') break;
                command = (char) b;
            }

            switch (command) {
                case 'P': {
                    while ((b = in.read()) != -1) {
                        if (b == '\n') break;
                        input = (char) b;
                    }
                    node.L(new Node(input));
                    curser++;
                    break;
                }
                case 'L': {
                    if (curser == 0) continue;
                    node = node.l;
                    curser--;
                    break;
                }
                case 'D': {
                    if (node.c == '\n') continue;
                    node = node.r;
                    curser++;
                    break;
                }
                case 'B': {
                    if (curser == 0) continue;
                    if (node.l.l != null) node.l.l.r = node;
                    node.l = node.l.l;
                    curser--;
                    break;
                }
            }
        }

        while (end != null) {
            sb.append(end.c);
            end = end.l;
        }

        sb.reverse();

        System.out.println(sb.toString());

    }
}
