package 신승용.WEEK06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] a = new int[N];
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(br.readLine().trim());

        Map<Integer, Integer> map = new HashMap<>();
        int window = 0;

        for (int i = 0; i < k; i++) {
            int v = a[i];
            int prev = map.getOrDefault(v, 0);
            if (prev == 0) window++;
            map.put(v, prev + 1);
        }
        int answer = window + (map.containsKey(c) ? 0 : 1);

        for (int i = 0; i < N; i++) {
            int left = a[i];
            int right = a[(i + k) % N];

            int leftCnt = map.get(left) - 1;
            if (leftCnt == 0) {
                map.remove(left);
                window--;
            } else {
                map.put(left, leftCnt);
            }

            int prev = map.getOrDefault(right, 0);
            if (prev == 0) window++;
            map.put(right, prev + 1);

            int cur = window + (map.containsKey(c) ? 0 : 1);
            if (cur > answer) answer = cur;
        }

        System.out.println(answer);
    }
}