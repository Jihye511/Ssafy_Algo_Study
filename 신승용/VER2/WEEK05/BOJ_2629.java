package 신승용.VER2.WEEK05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2629 {

    static int N;
    static int[] weights;
    static boolean[][] visited;
    static boolean[] possible;
    static int sum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine().trim());
        weights = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        sum = 0;
        for (int i = 1; i <= N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }

        visited = new boolean[N+1][sum+1];
        possible = new boolean[sum+1];

        dfs(0, 0);

        int M = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int marble = Integer.parseInt(st.nextToken());

            if (marble > sum) {
                sb.append("N ");
            } else if (possible[marble]) {
                sb.append("Y ");
            } else {
                sb.append("N ");
            }
        }

        System.out.println(sb.toString().trim());
    }

    static void dfs(int idx, int diff) {
        if (diff > sum) return;
        if (visited[idx][diff]) return;

        visited[idx][diff] = true;
        possible[diff] = true;

        if (idx == N) return;

        int w = weights[idx + 1];

        dfs(idx + 1, diff);
        dfs(idx + 1, Math.abs(diff - w));
        dfs(idx + 1, diff + w);
    }
}
