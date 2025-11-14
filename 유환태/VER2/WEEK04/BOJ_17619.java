package boj;

import java.util.*;
import java.io.*;

public class BOJ_17619 {
    static int N, Q;
    static class Log implements Comparable<Log>{
        int s;
        int e;
        int h;
        int idx;
        Log(int s, int e, int h, int idx){
            this.s = s;
            this.e = e;
            this.h = h;
            this.idx = idx;
        }

        @Override
        public int compareTo(Log o) {
            return this.s - o.s;
        }
    }
    static int[] parents;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        List<Log> logs = new ArrayList<>();
        parents = new int[N];
        for(int i = 0; i < N ; i++){
            parents[i] = i;
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            logs.add(new Log(s,e,h,i));
        }

        Collections.sort(logs);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (logs.get(i).e >= logs.get(j).s) {
                    union(logs.get(i).idx,logs.get(j).idx);
                }else{
                    break;
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for(int q = 0; q < Q; q++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            if (FindSet(a) == FindSet(b)) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }

    private static void union(int a, int b) {
        int pa = FindSet(a);
        int pb = FindSet(b);

        if(pa==pb) return;
        parents[pa] = pb;
    }

    private static int FindSet(int a) {
        if(a==parents[a]) return a;
        return parents[a] = FindSet(parents[a]);
    }
}
