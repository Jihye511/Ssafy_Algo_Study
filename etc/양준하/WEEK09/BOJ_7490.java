import java.io.*;

public class BOJ_7490 {
    static int T, N;
    static int[] op = new int[9];

    static void dfs(int idx, StringBuilder sb) {
        if (idx == N) {
            int sum = 0;
            int tmp = 1;

            for (int i = 1; i < N; i++) {
                if (op[i] == 10) {
                    tmp = tmp * op[i] + (tmp > 0 ? i+1 : -i-1);
                } else {
                    sum += tmp;
                    tmp = op[i] * (i+1);
                }
            }
            sum += tmp;

            if (sum == 0) {
                for (int i = 0; i < N; i++) {
                    if (op[i] == 0) sb.append(i+1);
                    else if (op[i] == 10) sb.append(' ').append(i+1);
                    else if (op[i] == 1) sb.append('+').append(i+1);
                    else if (op[i] == -1) sb.append('-').append(i+1);
                }
                sb.append('\n');
            }
            return;
        } else {
            op[idx] = 10;
            dfs(idx+1, sb);
            op[idx] = 1;
            dfs(idx+1, sb);
            op[idx] = -1;
            dfs(idx+1, sb);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            dfs(1, sb);
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
