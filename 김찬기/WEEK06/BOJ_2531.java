package WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_2531 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] type = new int[3001];

        int[] sushi = new int[N];
        for (int i = 0; i < N; ++i) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> set = new HashSet<>();
        set.add(C);
        for (int i = N-K+1; i < N; ++i) {
            ++type[sushi[i]];
            set.add(sushi[i]);
        }
        ++type[sushi[0]];
        set.add(sushi[0]);

        int result = set.size();
        for (int i = 1; i < N; ++i) {
            int idx = (N+i-K) % N;
            --type[sushi[idx]];
            if (type[sushi[idx]] == 0) {
                set.remove(sushi[idx]);
            }
            set.add(C);
            set.add(sushi[i]);
            ++type[sushi[i]];
            result = Math.max(result, set.size());
        }

        System.out.println(result);
    }
}
