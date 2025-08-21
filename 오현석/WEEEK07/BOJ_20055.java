import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] a = new int[2 * n];
        boolean[] r = new boolean[n]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int res = 0;

        while (true) {
            res++;

            int last = a[2 * n - 1];
            for (int i = 2 * n - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = last;

            for (int i = n - 1; i > 0; i--) {
                r[i] = r[i - 1];
            }
            r[0] = false;
            r[n - 1] = false; 

            for (int i = n - 2; i >= 0; i--) {
                if (r[i] && !r[i + 1] && a[i + 1] > 0) {
                    r[i] = false;
                    r[i + 1] = true;
                    a[i + 1]--;
                }
            }
            r[n - 1] = false;

            if (a[0] > 0 && !r[0]) {
                r[0] = true;
                a[0]--;
            }

            int cnt = 0;
            for (int i = 0; i < 2 * n; i++) {
                if (a[i] == 0) cnt++;
            }
            if (cnt >= k) {
                System.out.println(res);
                break;
            }
        }
    }
}
