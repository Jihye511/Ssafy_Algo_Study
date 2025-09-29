package WEEK13;

import java.util.*;
import java.io.*;

public class BOJ_14658 {
    
    static class Star {
        int x;
        int y;

        public Star() {}
        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N, M, L, K, max;
    static List<Star> list;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 별똥별 가로 길이
        M = Integer.parseInt(st.nextToken()); // 별똥별 세로 길이
        L = Integer.parseInt(st.nextToken()); // 트램펄린 한 변 길이
        K = Integer.parseInt(st.nextToken()); // 별똥별 수

        list = new ArrayList<>();
        for (int k=0; k<K; ++k) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Star(x, y));
        }

        max = Integer.MIN_VALUE;
        for (int i=0; i<K; ++i) {
            Star curr = list.get(i);
            for (int j=0; j<K; ++j) {
                Star next = list.get(j);
                solve(curr.x, next.y);
            }
        }

        System.out.println(K - max);
    }

    public static void solve(int x, int y) {
        Star star = new Star(x, y);

        int count = 0;
        for (int k=0; k<K; ++k) {
            Star other = list.get(k);
            if (isValid(star, other)) {
                ++count;
            }
            
        }

        max = Math.max(max, count);
    }

    public static boolean isValid(Star curr, Star other) {
        return (curr.x <= other.x && other.x <= curr.x+L) && (curr.y <= other.y && other.y <= curr.y+L);
    } 
}
