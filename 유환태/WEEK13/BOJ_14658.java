package boj;

import java.util.*;
import java.io.*;

public class BOJ_14658 {
    static class Star implements Comparable<Star>{
        int n;
        int m;
        Star(int n,int m){
            this.n=n;
            this.m=m;
        }

        @Override
        public int compareTo(Star o) {
            if(this.n == o.n){
                return this.m - o.m;
            } else{
                return this.n - o.n;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new  StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Star[] stars = new Star[K];

        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            stars[i] = new Star(n,m);
        }

        Arrays.sort(stars);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                int cnt = 0;
                int n = stars[i].n;
                int m = stars[j].m;
                int ln = n+L;
                int lm = m+L;

                for(int k=0;k<K;k++){
                    if(stars[k].n >= n && stars[k].n <= ln && stars[k].m >= m && stars[k].m <= lm){
                            cnt++;
                    }
                }
                ans = Math.max(ans,cnt);
            }
        }
        System.out.println(K-ans);
    }
}
