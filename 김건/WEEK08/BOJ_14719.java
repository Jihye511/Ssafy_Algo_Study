package Baekjoon.WEEK8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14719 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        st.nextToken();

        int W = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[W];

        for (int i =0; i<W; i++) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        int idx = 0, ans=0;

        int maxH=arr[idx],sMaxH,sMaxIdx;

        while (idx<W) {
            sMaxH=0;
            sMaxIdx=-1;
            boolean f= false;
            for (int i=idx+1; i<W; i++) {
                if (arr[i]>=maxH) {
                    f= true;
                    for (int j=idx+1; j<i; j++) {
                        ans+=arr[idx]-arr[j];
                    }
                    idx = i;
                    maxH = arr[i];
                    break;
                }
                if (arr[i]>sMaxH) {
                    sMaxH = arr[i];
                    sMaxIdx = i;
                }
            }
            if (f) continue;
            if (sMaxIdx!=-1) {
                f = true;
                for (int i = idx + 1; i < sMaxIdx; i++) {
                    ans += sMaxH - arr[i];
                }
                idx = sMaxIdx;
                maxH = sMaxH;
            }
            if (f) continue;
            idx++;
        }

        System.out.println(ans);
    }
}
