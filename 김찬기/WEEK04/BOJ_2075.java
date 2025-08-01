package WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_2075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> list = new ArrayList<>();
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; ++j) {
                list.add(Integer.parseInt(st.nextToken()));
            }
        }

        list.sort(Collections.reverseOrder());

        System.out.println(list.get(N-1));
    }
}
