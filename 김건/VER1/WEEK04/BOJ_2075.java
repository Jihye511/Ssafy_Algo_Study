package Baekjoon.WEEK4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2075 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N*N];
        for (int i = 0; i< N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                arr[i*N+j] =  Integer.parseInt(st.nextToken());
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[N*(N-1)]);
    }
}
