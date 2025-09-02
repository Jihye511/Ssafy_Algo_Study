import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited, finished;
    static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N+1];
        finished = new boolean[N+1];

        for (int i=1; i<=N; i++) {
            dfs(i, i);
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (int x : result) {
            System.out.println(x);
        }
    }

    static void dfs(int start, int target) {
        if (!visited[start]) {
            visited[start] = true;
            dfs(arr[start], target);
            visited[start] = false;
        } else if (start == target) {
            result.add(start);
        }
    }
}
