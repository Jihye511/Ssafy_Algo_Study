import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            dfs(N, 1, new char[N-1]);
            sb.append("\n");
        }
        System.out.println(sb);

    }

    public static void dfs(int N, int now, char[] ord){
        if (now == N){
            if (check(N, ord)){
                for (int i = 0; i < N-1; i++) {
                    sb.append(i+1).append(ord[i]);
                }
                sb.append(N);
                sb.append("\n");

            }
            return;
        }

        ord[now - 1] = ' ';
        dfs(N, now + 1, ord);

        ord[now - 1] = '+';
        dfs(N, now + 1, ord);

        ord[now - 1] = '-';
        dfs(N, now + 1, ord);
    }

    public static boolean check(int N, char[] ord){
        int sum = 0;
        int cur_num = 1;

        int op = 1;
        for (int i = 0; i < N-1; i++) {
            int next_num = i+2;
            if(ord[i] == ' '){
                cur_num = cur_num * 10 + next_num;
            }
            else {
                sum += cur_num * op;
                cur_num = next_num;
                if(ord[i] == '+'){
                    op = 1;
                }
                else {
                    op = -1;
                }
            }
        }

        sum += cur_num * op;

        if(sum == 0) return true;
        return false;
    }
}
