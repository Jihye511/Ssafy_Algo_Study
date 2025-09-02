import java.util.*;
import java.io.*;

public class Boj_2668_숫자고르기 {
    static int N;
    static int[] nums;
    static ArrayList<Integer> ans;
    static boolean[] visited;
    static boolean[] finished;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        nums = new int[N+1];

        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        visited = new boolean[N+1];
        finished = new boolean[N+1];

        ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        Collections.sort(ans);
        System.out.println(ans.size());
        for (int i : ans) {
            System.out.println(i);
        }

    }

    static void dfs(int u) {
        visited[u] = true;
        int nxt = nums[u];
        if (!visited[nxt]) {
            dfs(nxt);
        }

        else if (!finished[nxt]) {
            int v = nxt;
            do {
                ans.add(v);
                v = nums[v];
            } while (v != nxt);
        }

        finished[u] = true;
    }
    
}
