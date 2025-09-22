package boj;

import java.util.*;
import java.io.*;

public class BOJ_1027 {
    static int[] h;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine().trim());

        h = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            h[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i = 0; i < N; i++) {
            int left = 0, right = 0;

            for (int l = 0; l < i; l++) {
                boolean visible = true;
                for (int j = l + 1; j < i; j++) {
                    if (!checkVisible(l, i, j)) {
                        visible = false;
                        break;
                    }
                }
                if (visible) left++;
            }

            for (int r = i + 1; r < N; r++) {
                boolean visible = true;
                for (int j = i + 1; j < r; j++) {
                    if (!checkVisible(i, r, j)) {
                        visible = false;
                        break;
                    }
                }
                if (visible) right++;
            }


            ans = Math.max(ans, left + right);
        }

        System.out.println(ans);
    }

    static boolean checkVisible(int x1, int x2, int x3) {
        long y1 = h[x1], y2 = h[x2], y3 = h[x3];
        long lhs = (y2 - y1) * (x3 - x1);
        long rhs = (y3 - y1) * (x2 - x1);
        return lhs > rhs;
    }
}
