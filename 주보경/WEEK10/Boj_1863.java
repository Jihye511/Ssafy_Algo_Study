import java.util.*;
import java.io.*;
public class Boj_1863_스카이라인 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> dq = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!dq.isEmpty() && dq.peekLast() > y) {
                dq.pollLast();
            }

            if ( y > 0 && ( dq.isEmpty() || dq.peekLast() < y)) {
                dq.addLast(y);
                ans++;
            }
        }
        System.out.println(ans);
    }
}
