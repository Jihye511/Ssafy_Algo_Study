package Baekjoon.WEEK9;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_7682 {
    static int[][] var = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] in;

        int cO, cX, sub;
        boolean xW, oW, ins = false;
        char first;
        while (true) {
            in = br.readLine().toCharArray();

            if (in[0] == 'e') break;

            cO = 0;
            cX = 0;
            ins = true;
            for (int i=0; i<9; i++) {
                switch (in[i]) {
                    case 'O':
                        cO++;
                        break;
                    case 'X':
                        cX++;
                        break;
                }
            }

            sub = cX - cO;

            if (0<=sub&&sub<=1) {
                xW = false;
                oW = false;

                L:for (int[] v:var) {
                    for (int i:v) {
                        if (in[i]=='.') continue L;
                    }
                    first = in[v[0]];
                    if (in[v[1]]!=first) continue;
                    if (in[v[2]]!=first) continue;

                    switch (first) {
                        case 'X':
                            xW = true;
                            break;
                        case 'O':
                            oW = true;
                            break;
                    }
                }

                if (xW&&oW) {
                    sb.append("invalid").append('\n');
//                    System.out.println("invalid");
                }
                else {
//                    System.out.println(oW);
//                    System.out.println(xW);
//                    System.out.println(sub);
                    if ((xW&&sub==1)||(oW&&sub==0)||(!(oW||xW)&&cX+cO==9)) {
                        sb.append("valid").append('\n');
//                        System.out.println("valid");
                    }
                    else {
                        sb.append("invalid").append('\n');
//                        System.out.println("invalid");
                    }
                }
            }
            else sb.append("invalid").append('\n');
//            else System.out.println("invalid");
//            System.out.println();
        }

        if (ins) System.out.println(sb.toString());
    }
}
