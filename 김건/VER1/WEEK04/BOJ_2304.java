package Baekjoon.WEEK4;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class BOJ_2304 {
    static class Node implements Comparable<Node>{
        int idx, data;

        Node(int idx, int data) {
            this.idx = idx;
            this.data = data;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.idx, o.idx);
        }
    }
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();
        int b;
        while ((b = in.read()) != -1) {
            if (b == '\n')  break;
            sb.append((char) b);
        }

        int N = Integer.parseInt(sb.toString());
        ArrayList<Node> list = new ArrayList<>();

        for (int i =0; i<N; i++) {
            sb.setLength(0);

            while ((b = in.read()) != -1) {
                if (b == ' ')  break;
                sb.append((char) b);
            }

            int L = Integer.parseInt(sb.toString());

            sb.setLength(0);

            while ((b = in.read()) != -1) {
                if (b == '\n')  break;
                sb.append((char) b);
            }

            int H = Integer.parseInt(sb.toString());

            list.add(new Node(L, H));
        }

        Collections.sort(list);

        int ans = 0;
        L:for (int i = 0; i < list.size(); i++) {
            int cur = list.get(i).data;
            int max = -1, maxIdx = -1;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(j).data >= cur) {
                    ans += (list.get(j).idx - list.get(i).idx) * cur;
                    i=j-1;

                    continue L;
                }
                else {
                    if (max < list.get(j).data) {
                        max = list.get(j).data;
                        maxIdx = j;
                    }
                }
            }

            if (maxIdx != -1) {
                ans += (list.get(maxIdx).idx - list.get(i).idx) * max;
                ans += cur - max;
                i = maxIdx - 1;
            }
        }

        ans += list.getLast().data;

        System.out.println(ans);
    }
}
