import java.util.*;
import java.io.*;

public class Boj_1976_여행가자 {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N+1; j++) {
                int s = Integer.parseInt(st.nextToken());
                if (s == 1) {
                    union(i,j);
                }
            }
        }

        //확인
        st = new StringTokenizer(br.readLine());
        int prev = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (find(node) != prev) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");

    }

    static int find(int x) {
        if (parent[x] == x) {
            return parent[x] = x;
        }
        return find(parent[x]);
    }

    static void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px < py) {
            parent[py] = px;
        }
        else {
            parent[px] = py;
        }
    }
}
