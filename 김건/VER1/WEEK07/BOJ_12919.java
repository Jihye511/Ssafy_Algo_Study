package Baekjoon.WEEK7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_12919 {
    static char[] ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] in = br.readLine().toCharArray();
        ans = br.readLine().toCharArray();
        char[] arr = new char[ans.length];
        int l = in.length;
        for (int i = 0; i < in.length; i++) {
            arr[i] = in[i];
        }

        System.out.println(dfs(arr, l));
    }

    static int dfs(char[] arr, int l) {
        boolean f = false;

        L:for (int i = 0; i < ans.length - l + 1; i++) {
            if (arr[0] == ans[i]) {
                for (int j = i + 1; j < i + l; j++) {
                    if (ans[j] != arr[j - i]) continue L;
                }
                if (l == ans.length) return 1;
                f = true;
            }
        }
        if (l!=ans.length){
            L:
            for (int i = ans.length - 1; i >= l - 1; i--) {
                if (arr[0] == ans[i]) {
                    for (int j = i - 1; j > i - l; j--) {
                        if (ans[j] != arr[i - j]) continue L;
                    }
                    f = true;
                }
            }
        }
        if (!f && l == ans.length) return 0;
        int re = 0;
        if (f) {
            arr[l] = 'A';
            re = dfs(arr, l + 1);
            if (re == 0) {
                char tmp;
                for (int i = 0; i <= l / 2; i++) {
                    tmp = arr[i];
                    arr[i] = arr[l-i];
                    arr[l-i] = tmp;
                }
                arr[0] ='B';
                re = dfs(arr, l+1);
                for (int i = 0; i <= l / 2; i++) {
                    tmp = arr[i];
                    arr[i] = arr[l-i];
                    arr[l-i] = tmp;
                }
            }
        }
        return re;
    }
}