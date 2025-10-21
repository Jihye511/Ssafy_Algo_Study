import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    public void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        int[] dists = new int[N-1];
        int[] costs = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N-1; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }
        int lowestCost = Integer.MAX_VALUE;
        int dist = 0;
        int total = 0;
        for (int i=0; i<N-1; i++) {
            if (costs[i] < lowestCost) {
                total += dist * lowestCost;
                lowestCost = costs[i];
                dist = 0;
            }

            dist += dists[i];
        }

        total += dist * lowestCost;

        System.out.println(total);
    }
}
