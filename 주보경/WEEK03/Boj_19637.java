import java.util.*;
import java.io.*;

public class Boj_19637_IF문좀대신써줘 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //오름차순으로 나옴
        String[] ching = new String[N];
        int[] power = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ching[i] = st.nextToken();
            power[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());

            int start = 0;
            int end = N-1;
            while (start < end) {
                int middle = (start + end) / 2;

                if (target <= power[middle]) {
                    end = middle;
                }
                else {
                    start = middle + 1;
                }
            }
            sb.append(ching[start]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
