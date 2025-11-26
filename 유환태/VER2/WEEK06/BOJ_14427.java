package boj;

import java.util.*;
import java.io.*;

public class BOJ_14427 {
    static int N, M;
    static class A implements Comparable<A>{
        int index;
        int value;
        A(int i, int v){
            this.index = i;
            this.value = v;
        }

        @Override
        public int compareTo(A o) {
            if(this.value == o.value){
                return this.index - o.index;
            }
            return this.value - o.value;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());

        int[] number = new int[N];
        st = new StringTokenizer(br.readLine());

        PriorityQueue<A> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            number[i] = num;
            pq.add(new A(i, num));
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());

            if(op == 2){
                while(!pq.isEmpty()){
                    A cur = pq.element();

                    if(cur.value==number[cur.index]){
                        sb.append(cur.index+1).append("\n");
                        break;
                    }
                    pq.poll();
                    pq.add(new A(cur.index, number[cur.index]));

                }

            }else if(op == 1){
                int idx = Integer.parseInt(st.nextToken())-1;
                int newnum = Integer.parseInt(st.nextToken());
                number[idx] = newnum;
                pq.add(new A(idx, newnum));
            }
        }
        System.out.println(sb);
    }
}
