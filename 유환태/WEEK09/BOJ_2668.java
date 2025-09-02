package boj;

import java.util.*;
import java.io.*;

public class BOJ_2668 {
    static int N;
    static int[] num;
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N+1];
        v = new boolean[N+1];
        for(int i=1;i<=N;i++){
            num[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1;i<=N;i++){
            v[i] = true;
            dfs(i, i);
            v[i] = false;
        }
        System.out.println(list.size());
        for(int n : list){
            System.out.println(n);
        }
    }

    private static void dfs(int s, int e) {
        if(num[s]==e){
            list.add(e);
            return;
        }

        if(!v[num[s]]){
            v[num[s]] = true;
            dfs(num[s], e);
            v[num[s]] = false;
        }
    }
}
