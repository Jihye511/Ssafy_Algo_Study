package WEEK08;

import java.io.*;
import java.util.*;

/**
 * 산성 용액(1 ~ 10억) / 알칼리성 용액(-1 ~ -10억)
 * 혼합 = 용액의 특성값의 합 -> 0에 가장 가까운 용액을 만들려 함
 * 산성 + 산성 / 알칼리성 + 알칼리성일 수도 있음
 * 용액은 오름차순으로 주어짐
 */

public class BOJ_2467 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] solution = new int[N];
        for (int i=0; i<N; ++i) {
            solution[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int r = N-1;
        int min = 2000000001;
        int[] result = new int[2];

        while (l < r) {
            int curr = solution[l] + solution[r];
            if (Math.abs(curr) < min) {
                min = Math.abs(curr);
                result[0] = solution[l];
                result[1] = solution[r];
            }

            if (curr >= 0) {
                --r;
            }
            else {
                ++l;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
