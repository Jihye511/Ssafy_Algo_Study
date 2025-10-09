package 신승용.WEEK13;

import java.io.*;
import java.util.*;

public class BOJ_24337 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a + b - 1 > N) {
            System.out.println(-1);
            return;
        }

        int[] ans = new int[N];
        int idx = 0;
        int tallest = Math.max(a, b);
        int k = N - (a + b - 1);

        if (a == 1) {
            ans[idx++] = tallest;
            for (int i = 0; i < k; i++) ans[idx++] = 1;
            for (int h = b - 1; h >= 1; h--) ans[idx++] = h;
        } else {
            for (int i = 0; i < k; i++) ans[idx++] = 1;
            for (int h = 1; h <= a - 1; h++) ans[idx++] = h;
            ans[idx++] = tallest;
            for (int h = b - 1; h >= 1; h--) ans[idx++] = h;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (i > 0) sb.append(' ');
            sb.append(ans[i]);
        }
        System.out.println(sb);
    }
}
