import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int visit = 0;
        int[] visits = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            visits[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<X; i++) {
            visit+= visits[i];
        }
        int maxV = visit, s=0, days=1;
        for (int i=X; i<N; i++) {
            visit-=visits[s++];
            visit+=visits[i];
            if (visit == maxV) {
                days++;
            }
            if (visit > maxV) {
                maxV = Math.max(visit, maxV);
                days = 1;
            }
        }

        if (maxV == 0) System.out.println("SAD");
        else {
            System.out.println(maxV);
            System.out.println(days);
        }
    }
}
