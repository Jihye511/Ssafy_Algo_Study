package Baekjoon.WEEK12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027 {
    static int[] arr;
    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = 0, c;
        for (int i=0; i<N; i++) {
            c = 0;
            for (int j=0; j<N; j++) {
                if (i==j) continue;
                if (validation(i, j)) c++;
            }
//            System.out.println("i: "+i+" c:"+c);
            max = Math.max(c, max);
        }

        System.out.println(max);
    }

    static boolean validation(int n, int m) {
        int min = Math.min(n, m);
        int max = Math.max(n, m);
        double tan = tan(n, m);
        for (int i=min+1; i<max; i++) {
//            System.out.println(tan+" "+tan(n, i));
            if (tan(n, i)<=tan) {
                return false;
            }
        }
        return true;
    }

    static double tan(int n, int m) {
        return (double) (arr[n] - arr[m]) /Math.abs(n-m);
    }

}
