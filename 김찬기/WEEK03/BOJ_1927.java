package WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_1927 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> minHeap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; ++i) {
            int oper = Integer.parseInt(br.readLine());
            if (oper == 0) {
                if (minHeap.isEmpty()) {
                    sb.append("0");
                }
                else {
                    sb.append(minHeap.poll());
                }
                sb.append("\n");
            }
            else {
                minHeap.add(oper);
            }
        }

        System.out.println(sb);
    }
}
