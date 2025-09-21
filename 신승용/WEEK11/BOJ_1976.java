package 신승용.WEEK11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976 {
    static int[] parents;
    static int[] rank;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parents = new int[N + 1];
        rank = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
            rank[i] = 0;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){
                    unionSet(i, j);
                }
            }
        }

        int[] route = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        int root = findSet(route[0]);
        boolean isValid = true;

        for (int i = 0; i < M; i++) {
            if(findSet(route[i]) != root) {
                isValid = false;
                break;
            }
        }

        System.out.println(isValid ? "YES" : "NO");
    }

    static void unionSet(int i, int j){
        int pi = findSet(i);
        int pj = findSet(j);

        if(pi == pj) return;

        if (rank[pi] > rank[pj]) {
            parents[pj] = pi;
        } else {
            parents[pi] = pj;
            if (rank[pi] == rank[pj]) {
                rank[pj]++;
            }
        }
    }

    static int findSet(int x) {
        if (parents[x] == x) return x;
        return parents[x] = findSet(parents[x]);
    }
}
