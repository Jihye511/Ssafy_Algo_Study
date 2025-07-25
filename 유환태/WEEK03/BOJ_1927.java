package boj;

import java.util.*;
import java.io.*;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((n1,n2) -> n1-n2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {

            int op = Integer.parseInt(br.readLine());

            if(op == 0){
                if(pq.isEmpty()){
                    sb.append("0\n");
                }else{
                    sb.append(pq.poll()+"\n");
                }

            }else{
                pq.add(op);
            }
        }
        System.out.println(sb.toString());
    }
}
