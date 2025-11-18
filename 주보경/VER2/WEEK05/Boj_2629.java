import java.util.*;
import java.io.*;

public class Boj_2629_양팔저울 {
    static int[] w;
    static int MAX = 15000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //추 개수
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = new int[N+1];
        for (int i = 1; i <= N; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        boolean[][] dp = new boolean[N+1][MAX+1];
        //dp[i][w] : i번째 추까지 사용했을 때 무게 w(구슬쪽)를 만들 수 있는지 없는지 유무 true-> 가능 false -> 불가능

        // 1. 안쓰거나
        // 2. 구슬쪽 (왼쪽)
        // 3. 추쪽 (오른쪽)

        dp[0][0] = true;
        for (int i = 1; i <= N; i++) {
            int weight = w[i]; //i번째 추 무게
            for (int d = 0; d <= MAX; d++) {
                if (dp[i-1][d] == true) {
                    //i-1번째 추로 d무게 만들 수 있음
                    dp[i][d] = true; //암것도 안함
                    if (d + weight <= MAX) dp[i][d+weight] = true;
                    dp[i][Math.abs(d - weight)] = true;
                }
            }
        }


        int q = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            //유무 구하기
            int target = Integer.parseInt(st.nextToken());
            if (target > MAX) {
                sb.append("N ");
                continue;
            }
            if (dp[N][target] == true) sb.append("Y ");
            else sb.append("N ");
        }

        System.out.println(sb);
    }
}
