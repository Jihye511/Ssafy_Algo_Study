import java.io.*;
import java.util.*;

public class Main {

    static int N, A, B;
    static int[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        if (A + B - 1 > N) {
            System.out.println(-1);
            return;
        }

        arr = new int[N];

        if (A > 1) {
            for (int i = 0; i < N - (A + B - 1); i++) {
                arr[i] = 1;
            }

            int startIdx = N - (A + B - 1);

            for (int i = 0; i < A - 1; i++) {
                arr[startIdx + i] = i + 1;
            }

            arr[startIdx + A - 1] = Math.max(A, B);

            for (int i = 0; i < B - 1; i++) {
                arr[startIdx + A + i] = B - 1 - i;
            }

        } else {
            arr[0] = Math.max(A, B);

            for (int i = 0; i < B - 1; i++) {
                arr[N - B + 1 + i] = B - 1 - i;
            }

            for (int i = 1; i < N - B + 1; i++) {
                arr[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb);
    }
}
