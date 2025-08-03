package WEEK05;

import java.io.*;
import java.util.*;

public class BOJ_1138 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> result = new ArrayList<>();
        result.add(N);
        for (int i=N-2; i>=0; --i) {
            result.add(arr[i], i+1);
        }

        StringBuilder sb = new StringBuilder();
        for (int p : result) {
            sb.append(p).append(" ");
        }

        System.out.println(sb);

    }
}
