package Baekjoon.VER2.WEEK2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2343 {
    static int[] arr;
    static int N, M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];
        int maxL = 0, sum = 0;
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            maxL = Math.max(arr[i], maxL);
            sum += arr[i];
        }

        int s = maxL, e= sum, mid = 0, ans = Integer.MAX_VALUE;

        while (s<=e) {
            mid = (s+e)/2;

            if (check(mid)) {
                ans = Math.min(ans, mid);
                e = mid - 1;
            }
            else s = mid + 1;
        }

        System.out.println(ans);
    }

    private static boolean check(int n) {
        int c=1, sum=0;
        for (int i=0; i<N; i++) {
            sum+=arr[i];
            if (sum>n) {
                if (c==M) return false;
                c++;
                sum = arr[i];
            }
        }

        return true;
    }
}