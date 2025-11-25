package Baekjoon.VER2.WEEK6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2252 {
    static int N, M;
    static int[] inDegree;
    static List<Integer>[] nexts;
    static int[] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        inDegree = new int[N+1];
        nexts = new List[N+1];
        result = new int[N];

        for (int i=1; i<=N; i++) {
            nexts[i] = new LinkedList<>();
        }

        int s, e;
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            inDegree[e]++;
            nexts[s].add(e);
        }

        topologicalSort();


    }

    static void topologicalSort() {
        Queue<Integer> que = new ArrayDeque<>();

        for (int i=1; i<=N; i++) {
            if (inDegree[i]==0) que.add(i);
        }

        int cur;
        for (int i=0; i<N; i++) {
            if (que.isEmpty()) {
                System.out.println(-1);
                break;
            }
            cur = que.poll();


            result[i] = cur;
            for (int next: nexts[cur]) {
                if (--inDegree[next]==0)
                    que.add(next);
            }
        }

        StringBuilder sb= new StringBuilder();
        sb.append(result[0]);
        for (int i=1; i<N; i++) {
            sb.append(' ').append(result[i]);
        }

        System.out.println(sb.toString());
    }
}
