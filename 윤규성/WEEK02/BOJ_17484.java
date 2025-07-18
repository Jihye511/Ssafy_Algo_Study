import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17484 {

    public static int N, M, ans ;
    public static int[][] map;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for(int i = 0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;

        for(int i = 0; i<M; i++) {
            go(0, 0, i, 2);
        }

        System.out.print(ans);

    }

    private static void go(int val, int depth, int now, int pre) {
        if(depth == N ) {
            ans = Math.min(val, ans);
            return;
        }

        for(int d = -1 ; d < 2; d++){
            if(now + d < 0 || now + d >= M) continue;
            if(d == pre) continue;

            go(val + map[depth][now], depth + 1, now + d, d);
        }

    }
}
