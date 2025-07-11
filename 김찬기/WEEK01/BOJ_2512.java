package WEEK01;

import java.io.*;
import java.util.*;

public class BOJ_2512 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        for (int i=0; i<N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        int M = Integer.parseInt(br.readLine());

        // 예산이 N이고 최솟값이 N보다 클 경우 최대 지급액은 1이어야 하는데 arr의 최솟값을 l로 잡으면 이때 반례가 생김
        int l = 1;
        int r = max;

        int answer = 0;
        while (l <= r) {
            int mid = l + (r-l)/2;
//            System.out.println("중간: " + mid);
            if (check(arr, M, mid)) {
//                System.out.println("양수: " + remain);
                l = mid+1;
                answer = mid;
            }
            else {
//                System.out.println("음수: " + remain);
                r = mid-1;
            }
        }

        System.out.println(answer);

    }

    public static boolean check(int[] arr, int M, int mid) {
        for (int i=0; i<arr.length; ++i) {
            if (arr[i] > mid) {
                M -= mid;
            }
            else {
                M -= arr[i];
            }
        }

        return M >= 0;
    }
}
