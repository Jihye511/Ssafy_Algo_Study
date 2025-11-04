import java.io.*;
import java.util.*;

public class Main_2531 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] sushi = new int[N];
        for (int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());

        int[] cnt = new int[d + 1];
        int kinds = 0;

        for (int i = 0; i < k; i++) {
            if (cnt[sushi[i]] == 0) kinds++;
            cnt[sushi[i]]++;
        }

        int max = kinds;
        if (cnt[c] == 0) max++;

        for (int i = 1; i < N; i++) {
            int out = sushi[(i - 1) % N];
            if (cnt[out] == 1) kinds--;
            cnt[out]--;

            int in = sushi[(i + k - 1) % N];
            if (cnt[in] == 0) kinds++;
            cnt[in]++;

            int current = kinds;
            if (cnt[c] == 0) current++;
            if (current > max) max = current;
        }

        System.out.println(max);
    }
}
