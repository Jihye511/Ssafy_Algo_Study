import java.util.*;
import java.io.*;

public class Boj_1697_숨바꼭질 {
    static int N = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int curr = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // 앞,뒤,x/2
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<int[]> dq = new ArrayDeque<>();

        dist[curr] = 1;
        dq.add(new int[] {curr,0});
        while(!dq.isEmpty()) {
            int[] e = dq.poll();
            int loc = e[0];  //위치
            int cnt = e[1];  //이동횟수
            if (cnt >= dist[loc]) continue;
            dist[loc] = cnt+1;
            if (inRange(loc + 1)) dq.add(new int[] {loc + 1, cnt + 1});
            if (inRange(loc-1)) dq.add(new int[] {loc-1, cnt+1});
            if (inRange(loc * 2)) dq.add(new int[] {loc * 2, cnt + 1});
        }

        System.out.println(dist[target]-1);


    }

    static boolean inRange(int num) {
        return num >= 0 && num < N;
    }
}
