package Baekjoon.VER2.WEEK3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15961 {
    
    static int[] arr;
    static int[] arr2;
    
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int max = 0;

        arr = new int[N + k - 1];
        arr2 = new int[d + 1];
        arr2[c] = 1;
        max = 1;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k - 1; i++) {
            arr[N + i] = arr[i];
        }

        int l = 0;
        int r = k;
        for (int i = l; i < r; i++) {
            if (arr2[arr[i]] == 0) {
                max++;
            }
            arr2[arr[i]] += 1;
        }

        int ans = max;
        for (; r < arr.length; r++) {
            arr2[arr[l]] -= 1;
            if (arr2[arr[l]] == 0)
                ans -= 1;
            if (arr2[arr[r]] == 0)
                ans += 1;
            arr2[arr[r]] += 1;
            max = Math.max(max, ans);
            l++;
        }

        System.out.println(max);
    }
}
