package VER2.WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_17619 {

    static class Log {
        int num;
        int x1;
        int x2;
        int y;

        public Log(int num, int x1, int x2, int y) {
            this.num = num;
            this.x1 = x1;
            this.x2 = x2;
            this.y = y;
        }
    }

    static int N, Q;
    static List<Log> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i=1; i<=N; ++i) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(new Log(i, x1, x2, y));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.x1 == o2.x1) {
                return Integer.compare(o1.x2, o2.x2);
            }

            return Integer.compare(o1.x1, o2.x1);
        });

        int tree = 0;
        int idx = 1;

        int[] parent = new int[N+1];
        Log curr = list.get(0);
        int l = curr.x1;
        int r = curr.x2;
        parent[curr.num] = tree;
        while (idx < N) {
            curr = list.get(idx);

            if (curr.x1 <= r) {
                r = Math.max(r, curr.x2);
                parent[curr.num] = tree;
            }
            else {
                l = curr.x1;
                r = curr.x2;
                ++tree;
                parent[curr.num] = tree;
            }

            ++idx;
        }

        StringBuilder sb = new StringBuilder();
        while (Q > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int result = 0;

            if (parent[s] == parent[e]) {
                result = 1;
            }
            sb.append(result).append("\n");
            --Q;
        }

        System.out.println(sb);

    }
}
