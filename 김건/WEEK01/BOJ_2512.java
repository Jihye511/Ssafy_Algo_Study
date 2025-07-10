import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[][] costs = new int[N + 1][3];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            costs[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());

        Arrays.sort(costs, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[0], b[0]);
            }
        });

        int target = -1;
        int ans = -1;
        for (int i =1; i<=N; i++) {
            costs[i][1] = costs[i-1][1] + costs[i][0];
            costs[i][2] = costs[i][1] + costs[i][0]* (N-i);
            if (costs[i][2] > M) {
                target = i;
                break;
            }
        }

        if (target == -1) {
            ans = costs[N][0];
        }
        else {
            int s = costs[target - 1][0];
            int e = costs[target][0];
            int mid = -1;
            int cost = -1;
            target -= 1;

            while (s <= e) {
                mid = (s + e) / 2;

                cost = costs[target][1] + (N - target) * mid;

                if (cost == M) {
                    ans = mid;
                    break;
                } else if (cost > M) e = mid - 1;
                else s = mid + 1;
            }

            if (ans == -1) {
                if (cost > M) mid -=1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }
}