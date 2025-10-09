package WEEK11;

import java.io.*;
import java.util.*;

public class BOJ_1976 {

    static int[] parent = new int[201];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        init(N);

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    union(i, j);
                }
            }
        }

        int[] plan = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; ++i) {
            plan[i] = Integer.parseInt(st.nextToken())-1;
        }

        int start = plan[0];
        boolean isValid = true;
        for (int i=1; i<M; ++i) {
            if (find(start) != find(plan[i])) {
                isValid = false;
            }
        }

        if (isValid) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    public static void init(int N) {
        for (int i=1; i<=N; ++i) {
            parent[i] = i;
        }
    }

    public static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) {
            return;
        }

        if (pa < pb) {
            parent[pb] = pa;
        }
        else {
            parent[pa] = pb;
        }

    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
