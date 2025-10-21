import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_19637 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] badge = new String[N];
        int[] range = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            badge[i] = st.nextToken();
            range[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int pivot = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N - 1;
            int answer = 0;

            while (left <= right) {
                int mid = (left + right) / 2;
                if (pivot <= range[mid]) {
                    answer = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            sb.append(badge[answer]).append('\n');
        }

        System.out.print(sb);
    }
}
