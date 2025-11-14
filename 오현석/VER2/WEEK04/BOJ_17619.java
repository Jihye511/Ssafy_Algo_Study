import java.util.*;
import java.io.*;

public class Main {

    static class Log {
        int x1, x2, idx;

        Log(int x1, int x2, int idx) {
            this.x1 = x1;
            this.x2 = x2;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        Log[] arr = new Log[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Log(x1, x2, i + 1);
        }

        Arrays.sort(arr, (a, b) -> a.x1 - b.x1);

        int[] group = new int[N + 1];  // 1-index
        int currentGroup = 1;

        int curEnd = arr[0].x2;
        group[arr[0].idx] = currentGroup;

        for (int i = 1; i < N; i++) {
            Log log = arr[i];

            if (log.x1 <= curEnd) {
                group[log.idx] = currentGroup;
                curEnd = Math.max(curEnd, log.x2);
            } else {
                currentGroup++;
                group[log.idx] = currentGroup;
                curEnd = log.x2;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (group[u] == group[v]) sb.append("1\n");
            else sb.append("0\n");
        }

        System.out.print(sb);
    }
}
