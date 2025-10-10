package Baekjoon.WEEK14;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_3687 {
    static int[][] arr = new int[][] {{8},{},{1},{7},{4},{2},{6}};
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M;
        for (int i=0; i<N; i++) {
            M = Integer.parseInt(br.readLine());
            smallest(M);
            biggest(M);
        }
    }

    static void biggest(int n) {

        int q=n/2;
        if (n%2==0) {
            sb.append('1');
        }
        else {
            sb.append('7');
        }
        for (int i=1; i<q; i++)
            sb.append('1');

        System.out.println(sb.toString());
    }
    static void smallest(int n) {
        sb.setLength(0);
        int q=n/7;
        int r=n%7;
        int c=q;
        switch (r) {
            case (0): {
                sb.append('8');
                q--;
                break;
            }
            case (1): {
                sb.append('1');
                sb.append('0');
                q--;
                break;
            }
            case (3): {
                if (q>1) {
                    sb.append('2');
                    sb.append('0');
                    sb.append('0');
                    q-=2;
                }
                else if (q>0) {
                    sb.append('2');
                    sb.append('2');
                    q--;
                }
                else {
                    sb.append('7');
                    q--;
                }
                break;
            }
            case (4): {
                if (q>0) {
                    sb.append('2');
                    sb.append('0');
                    q--;
                }
                else {
                    sb.append('4');
                    q--;
                }
                break;
            }
            default: {
                sb.append(arr[r][0]);
                if (q>0)
                    sb.append('8');
                q--;
                break;
            }
        }
        for (int i=0; i<q; i++) {
            sb.append('8');
        }

        sb.append(' ');
    }
}
