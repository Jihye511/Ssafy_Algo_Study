package WEEK05;

import java.io.*;
import java.util.*;

public class BOJ_1446 {

    static class Shortcut implements Comparable<Shortcut> {
        int start;
        int end;
        int length;

        public Shortcut() {}
        public Shortcut(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Shortcut o) {
            if (this.start == o.start) {
                if (this.end == o.end) {
                    return Integer.compare(this.length, o.length);
                }

                return Integer.compare(this.end, o.end);
            }

            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<Shortcut> list = new ArrayList<>();
        for (int i=0; i<N; ++i) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            list.add(new Shortcut(s, e, l));
        }

        Collections.sort(list);

        int[] dist = new int[D+1];
        for (int i=0; i<dist.length; ++i) {
            dist[i] = i;
        }

        int idx = 1;
        for (Shortcut sc : list) {
            if (sc.end > D) {
                continue;
            }

            while (idx <= sc.start) {
                if (dist[idx] > dist[idx - 1] + 1) {
                    dist[idx] = dist[idx - 1] + 1;
                }
                ++idx;
            }
            if (dist[sc.start] + sc.length < dist[sc.end] && (sc.end - sc.start) > sc.length) {
                dist[sc.end] = dist[sc.start] + sc.length;
            }
        }

        for (int i=1; i<dist.length; ++i) {
            if (dist[i] > dist[i-1] + 1) {
                dist[i] = dist[i-1] + 1;
            }
        }

        System.out.println(dist[D]);
    }
}
