package WEEK06;

import java.io.*;
import java.util.*;

public class BOJ_17615 {
    static int N;
    static char[] balls;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        balls = br.readLine().toCharArray();

        int cntR = 0;
        int cntB = 0;
        int sideR = 0;
        int sideB = 0;

        int front = getSide(0, N, 1);
        int back = getSide(N-1, -1, -1);

        if (balls[0] == 'R') {
            sideR = front;
        }
        else {
            sideB = front;
        }

        if (balls[N-1] == 'R') {
            sideR = Math.max(sideR, back);
        }
        else {
            sideB = Math.max(sideB, back);
        }


        for (int i=0; i<N; ++i) {
            if (balls[i] == 'R') {
                ++cntR;
            }
            else {
                ++cntB;
            }
        }

//        System.out.println(cntR);
//        System.out.println(sideR);
//        System.out.println(cntB);
//        System.out.println(sideB);

        System.out.println(Math.min(cntR-sideR, cntB-sideB));
    }

    public static int getSide(int start, int end, int unit) {
        char prev = balls[start];
        int cnt = 0;
        if (unit > 0) {
            for (int i=start; i<end; i += unit) {
                if (prev != balls[i]) {
                    break;
                }
                ++cnt;
            }
        }
        else {
            for (int i=start; i>end; i += unit) {
                if (prev != balls[i]) {
                    break;
                }
                ++cnt;
            }
        }

        return cnt;
    }
}
