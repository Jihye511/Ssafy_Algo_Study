package WEEK02;

import java.io.*;
import java.util.*;

public class BOJ_19941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String table = br.readLine();
        List<Integer> people = new ArrayList<>();
        boolean[] used = new boolean[N];
        for (int i=0; i<table.length(); i++) {
            if (table.charAt(i) == 'P') {
                people.add(i);
                used[i] = true;
            }
        }

        int result = 0;
        for (int p : people) {
            int lo = Math.max(p-K, 0);
            int hi = Math.min(used.length-1, p+K);
            for (int i=lo; i<=hi; i++) {
                if (!used[i]) {
                    used[i] = true;
                    ++result;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}

