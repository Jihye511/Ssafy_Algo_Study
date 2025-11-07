package boj;

import java.util.*;
import java.io.*;

public class BOJ_1931 {
    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        Meeting(int s, int e){
            this.start = s;
            this.end = e;
        }
        @Override
        public int compareTo(Meeting o) {
            if(this.end == o.end) {
                return this.start - o.start;
            }
            return this.end - o.end;
        }
    }
    static PriorityQueue<Meeting> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pq.add(new Meeting(s,e));
        }

        int count = 0;
        int end = 0;
        while(!pq.isEmpty()) {

            Meeting cur = pq.poll();
            if(cur.start >= end) {
                end = cur.end;
                count++;
            }
        }
        System.out.println(count);
    }
}

