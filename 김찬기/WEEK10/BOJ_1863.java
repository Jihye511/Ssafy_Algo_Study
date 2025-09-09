package WEEK10;

import java.io.*;
import java.util.*;

public class BOJ_1863 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Integer> city = new ArrayList<>();

        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            city.add(y);
        }

        boolean[] used = new boolean[500001];
        int curr = 0;
        used[curr] = true;
        int cnt = 0;
        for (int i=0; i<city.size(); ++i) {
            int height = city.get(i);
            if (height > curr) {
                used[height] = true;
                ++cnt;
                curr = height;
//                System.out.println(height);
            }
            else {
                if (!used[height]) {
                    ++cnt;
                    used[height] = true;
//                    System.out.println(height);
                }
                for (int l = curr; l>height; --l) {
                    used[l] = false;
                }
                curr = height;

            }
        }

        System.out.println(cnt);
    }
}
