import java.util.*;
import java.io.*;

public class Main {
    static int MAX = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        // -1, +1, *2
        boolean[] visited = new boolean[MAX];
        int[] time = new int[MAX];
        Arrays.fill(time, MAX+1);
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {start, 0});


        while (!dq.isEmpty()) {
            int[] ele = dq.poll();
            int loc = ele[0];
            int curr = ele[1];

            if (loc == target) {
                System.out.println(curr);
                return;
            }
            if (visited[loc]) continue;
            if (inRange(loc+1)) dq.add(new int[] {loc+1,curr+1});
            if (inRange(loc-1)) dq.add(new int[] {loc-1,curr+1});
            if (inRange(loc * 2)) dq.add(new int[] {loc * 2, curr});
            visited[loc] = true;
            time[loc] = curr;

        }

    }

    static boolean inRange(int loc) {
        return 0 <= loc && loc < MAX;
    }
}
