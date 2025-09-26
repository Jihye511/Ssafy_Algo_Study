package WEEK12;

import java.io.*;
import java.util.*;

public class BOJ_2179 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i=0; i<N; ++i) {
            String s = br.readLine();
            if (!list.contains(s)) {
                list.add(s);
            }
        }

        int max = Integer.MIN_VALUE;
        String[] result = new String[2];
        for (int i=0; i<list.size()-1; ++i) {
            String curr = list.get(i);
            for (int j=i+1; j<list.size(); ++j) {
                String next = list.get(j);
                int minLength = Math.min(curr.length(), next.length());

                int common = 0;
                for (int k=0; k<minLength; ++k) {
                    if (curr.charAt(k) != next.charAt(k)) {
                        break;
                    }
                    ++common;
                }
                if (max < common) {
                    result[0] = curr;
                    result[1] = next;
                    max = common;
                }
            }
        }

        for (int i=0; i<result.length; ++i) {
            System.out.println(result[i]);
        }
    }
}
