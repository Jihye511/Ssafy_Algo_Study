import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            dfs(0, 1, 2, "1", N); 
            sb.append("\n");       
        }
        System.out.print(sb);
    }

    // sum: 확정된 항들의 합, cur: 현재 진행 중인 항(부호 포함), next: 다음에 붙일 숫자
    static void dfs(int sum, int cur, int next, String expr, int N) {
        if (next == N + 1) {            // 모든 숫자를 다 썼을 때
            if (sum + cur == 0) sb.append(expr).append("\n");
            return;
        }

        // 공백
        int joined = (cur >= 0) ? cur * 10 + next : cur * 10 - next;
        dfs(sum, joined, next + 1, expr + " " + next, N);

        // 덧셈
        dfs(sum + cur, +next, next + 1, expr + "+" + next, N);

        // 뺄셈
        dfs(sum + cur, -next, next + 1, expr + "-" + next, N);
    }
}
