package VER2.WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_1931 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][2];
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[1], o2[1]);
        });
        int prev = 0;
        int cnt = 0;
        for (int i=0; i<N; ++i) {
            if (arr[i][0] >= prev) {
                ++cnt;
                prev = arr[i][1];
            }
        }

        System.out.println(cnt);
    }
}
