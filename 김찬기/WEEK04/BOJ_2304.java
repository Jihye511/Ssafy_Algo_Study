package WEEK04;

import java.io.*;
import java.util.*;

public class BOJ_2304 {

    static int N, max;
    static Map<Integer, Integer> map;
    static List<Integer> key;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new HashMap<>();

        max = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            map.put(idx, H);
            if (max < H) {
                max = H;
            }
        }

        key = new ArrayList<>(map.keySet());
        Collections.sort(key);
        calc();
    }

    public static void calc() {

        int size = 0;
        int currMax = 0;
        int leftIdx = 0;

        for (int i=0; i<key.size(); ++i) {
            int idx = key.get(i);
            int h = map.get(idx);

            if (currMax < h) {
                size += currMax * (idx - leftIdx);
                leftIdx = idx;
                currMax = h;
            }

            if (h == max) {
                break;
            }
        }


        currMax = 0;
        int rightIdx = 0;
        for (int i=key.size()-1; i>=0; --i) {
            int idx = key.get(i);
            int h = map.get(idx);

            if (currMax < h) {
                size += currMax * (rightIdx-idx);
                rightIdx = idx;
                currMax = h;
            }

            if (h == max) {
                break;
            }
        }

        size += (rightIdx-leftIdx+1) * max;

        System.out.println(size);
    }
}
