import java.util.*;
import java.io.*;

public class Boj_16928_뱀과사다리게임 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[101];
        int[] cnt = new int[101];
        Arrays.fill(cnt, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            map[v] = u;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());
            map[v] = u;
        }


        Deque<Integer> dq = new ArrayDeque<>();
        //bfs 1 ~ 6
        dq.add(1);
        cnt[1] = 0;
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            for (int i = 1; i <= 6; i++) {
                int nxt = curr + i;
                if (nxt <= 100) {
                    if (map[nxt] != 0) {
                        //사다리나 뱀
                        if (cnt[map[nxt]] > cnt[curr] + 1) {
                            cnt[map[nxt]] = cnt[curr] + 1;
                            dq.add(map[nxt]);
                        }
                    }
                    else {
                        if (cnt[nxt] > cnt[curr] + 1) {
                            cnt[nxt] = cnt[curr] + 1;
                            dq.add(nxt);
                        }
                    }
                }
            }
        }
        System.out.println(cnt[100]);
    }
}
