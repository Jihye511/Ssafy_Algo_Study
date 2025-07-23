package WEEK03;

import java.io.*;
import java.util.*;

public class BOJ_22233 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i=0; i<N; ++i) {
            set.add(br.readLine());
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; ++i) {
            String[] inputs = br.readLine().split(",");
            for (String input : inputs) {
                if (set.contains(input)) {
                    set.remove(input);
                }
            }
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}
