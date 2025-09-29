import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K;

    static class P {
        int x, y;
        P(int x, int y){ this.x = x; this.y = y; }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로 범위 (0..N)
        M = Integer.parseInt(st.nextToken()); // 세로 범위 (0..M)
        L = Integer.parseInt(st.nextToken()); // 그물(정사각형) 한 변 길이
        K = Integer.parseInt(st.nextToken()); // 별 개수

        List<P> stars = new ArrayList<>(K);
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new P(x, y));
        }

        int best = 0;
        for (int i = 0; i < K; i++) {
            int left = stars.get(i).x;          // 그물의 x 좌표(좌측)
            if (left + L > N) left = Math.max(0, N - L);

            for (int j = 0; j < K; j++) {
                int bottom = stars.get(j).y;    // 그물의 y 좌표(아랫변)
                if (bottom + L > M) bottom = Math.max(0, M - L);

                int right = left + L;
                int top = bottom + L;

                int cnt = 0;
                for (int t = 0; t < K; t++) {
                    P p = stars.get(t);
                    if (left <= p.x && p.x <= right && bottom <= p.y && p.y <= top) {
                        cnt++;
                    }
                }
                best = Math.max(best, cnt);
            }
        }
         System.out.println(K - best);
    }
}
