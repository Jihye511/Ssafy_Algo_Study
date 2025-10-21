package Baekjoon.WEEK5;

import java.io.InputStream;

public class BOJ_20922 {
    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        StringBuilder sb = new StringBuilder();

        int b;
        while ((b = in.read())!=-1) {
            if (b==' ') break;
            sb.append((char) b);
        }

        int N = Integer.parseInt(sb.toString());

        sb.setLength(0);
        while ((b = in.read())!=-1) {
            if (b=='\n') break;
            sb.append((char) b);
        }

        int K = Integer.parseInt(sb.toString());

        int[] arr = new int[N];
        int[] count =  new int[100000];
        int maxL = 0, s = 0, e = 0;

        Integer S, len=0;
        for (int i = 0; i < N; i++) {
            sb.setLength(0);
            while ((b = in.read())!=-1) {
                if (b==' '||b=='\n') break;
                sb.append((char) b);
            }
            int n = Integer.parseInt(sb.toString())-1;
            arr[i] = n;
            if(count[n]==K) {
                maxL = Math.max(maxL, e-s);
                while (s<e) {
                    count[arr[s]]--;
                    if (arr[s++]==n) {
                        break;
                    }
                }
            }
            e++;
            count[n]++;
        }

        maxL = Math.max(maxL, e-s);

        System.out.println(maxL);
    }
}
