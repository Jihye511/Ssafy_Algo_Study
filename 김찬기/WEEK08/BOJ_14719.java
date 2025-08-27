package WEEK08;

import java.io.*;
import java.util.*;

public class BOJ_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] block = new int[W];
        for (int i=0; i<W; ++i) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int water = 0;
        for (int i=1; i<W-1; ++i) {
            int maxL = block[i];
            int maxR = block[i];
            for (int l=i-1; l>=0; --l) {
                maxL = Math.max(maxL, block[l]);
            }

            for (int r=i+1; r<W; ++r) {
                maxR = Math.max(maxR, block[r]);
            }

//            System.out.println(maxL + " , " + maxR);

            water += Math.min(maxL, maxR) - block[i];
        }

        System.out.println(water);
    }
}
