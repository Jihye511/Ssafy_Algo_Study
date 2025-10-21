package Baekjoon.WEEK5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

    public class BOJ_1260 {
        static TreeSet<Integer>[] sets;
        static int V;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();

            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            sets = new TreeSet[V+1];

            for (int i=1; i<=V; i++) {
                sets[i] = new TreeSet<>();
            }
            int s;
            int e;
            for (int i=0; i<E; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                sets[s].add(e);
                sets[e].add(s);
            }

            dfs(S, new boolean[V+1], sb);
            sb.append("\n");
            bfs(S, sb);

            System.out.println(sb);
        }

        public static void bfs(int s, StringBuilder sb) {
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(s);
            boolean[] v = new boolean[V+1];
            v[s] = true;

            while(!q.isEmpty()) {
                int cur = q.poll();
                sb.append(cur+" ");
                for (int next : sets[cur]) {
                    if (v[next]) continue;
                    q.offer(next);
                    v[next] = true;
                }
            }
        }
        public static void dfs(int s, boolean[] v, StringBuilder sb) {
            sb.append(s+" ");
            v[s] = true;

            for (int next:sets[s]) {
                if (v[next]) continue;
                v[next]= true;
                dfs(next, v, sb);
            }
        }
    }