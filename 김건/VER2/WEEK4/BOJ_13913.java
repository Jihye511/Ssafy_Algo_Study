package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_13913 {
    static int N, K;
    static int[] arr;
    static boolean[] v;
    static BufferedReader br; 
    
    static class Pos {
        int n, c;
        
        Pos(int n, int c) {
            this.n = n;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[100001];
        v = new boolean[100001];
        if (N==K) {
        	System.out.println(0);
        	System.out.println(N);
        }
        else 
        	bfs(N);
    }
    
    public static void bfs(int N) throws Exception {
        Queue<Pos> que = new ArrayDeque<>();
        
        que.add(new Pos(N, 0));
        arr[N] = -1;
        v[N] = true;
        int nn;
        while (!que.isEmpty()) {
            Pos cur = que.poll();
            
            if (cur.n == K) {
                System.out.println(cur.c);
                Stack<Integer> stack = new Stack<>();
                stack.add(K);
                while (arr[K]!=-1) {
                	stack.add(arr[K]);
                	K = arr[K];
                }
                StringBuilder sb = new StringBuilder();
                sb.append(stack.pop());
                while (!stack.isEmpty()) {
                	sb.append(' ').append(stack.pop());
                }
                
                System.out.println(sb.toString());
                return;
            }
            
            nn = cur.n-1;
            if (nn>=0&&!v[nn]) {
            	arr[nn] = cur.n;
            	que.add(new Pos(nn, cur.c+1));
            	v[nn] = true;
            }
            nn = cur.n+1;
            if (nn<=100000&&!v[nn]) {
            	arr[nn] = cur.n;
            	que.add(new Pos(nn, cur.c+1));
            	v[nn] = true;
            }
            nn = cur.n*2;
            if (nn<=100000&&!v[nn]) {
            	arr[nn] = cur.n;
            	que.add(new Pos(nn, cur.c+1));
            	v[nn] = true;
            }
        }
    }
}
