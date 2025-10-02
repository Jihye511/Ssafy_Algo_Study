package Baekjoon.WEEK13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_24337 {
    static int N, A, B;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int minL = A+B-1;
        if (minL>N) {
            System.out.println(-1);
        }
        else {
            int last = Math.max(A, B);
            StringBuilder sb = new StringBuilder();
            if (A==1) {
                sb.append(last).append(' ');
                for (int i=1; i<=N-minL; i++) {
                    sb.append(1).append(' ');
                }

                if (B!=1) {
                    for (int i=B-1; i>1; i--) {
                        sb.append(i).append(' ');
                    }
                    sb.append(1);
                }


            }
            else {
                for (int i=0; i<N-minL; i++) {
                    sb.append(1).append(' ');
                }

                for (int i=1; i<A;i++) {
                    sb.append(i).append(' ');
                }
                sb.append(last).append(' ');

                if (B!=1) {
                    for (int i=B-1; i>1; i--) {
                        sb.append(i).append(' ');
                    }
                    sb.append(1);
                }
            }

            System.out.println(sb.toString());
        }
    }
}