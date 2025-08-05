        import java.util.*;
        import java.io.*;

        public class Main {

            static int N, M, V;
            static ArrayList<ArrayList<Integer>> adj;
            public static void main(String[] args) throws Exception{
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                V = Integer.parseInt(st.nextToken());

                adj = new ArrayList<>();
                for (int i = 0; i < N+1; i++) {
                    adj.add(new ArrayList<>());
                }

                int a, b;
                for (int i = 0; i < M; i++) {
                    st = new StringTokenizer(br.readLine());
                    a = Integer.parseInt(st.nextToken());
                    b = Integer.parseInt(st.nextToken());
                    adj.get(a).add(b);
                    adj.get(b).add(a);

                }

                for (int i = 1; i < N+1; i++) {
                    Collections.sort(adj.get(i));
                }

                StringBuilder sb1 = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();

                dfs(V, new boolean[N+1], sb1);
                bfs(sb2);

                System.out.println(sb1);
                System.out.println(sb2);

            }

            static void dfs(int k, boolean[] visited, StringBuilder sb){
                if(check(visited)){

                    return;
                }

                if(!visited[k]){
                    sb.append(k).append(" ");
                    visited[k] = true;
                    for (int i : adj.get(k)) {
                        if(!visited[i]){
                            dfs(i, visited, sb);
                        }
                    }
                }
            }

            static boolean check(boolean[] visited){
                for (int i = 1; i < visited.length; i++) {
                    if(!visited[i]) return false;
                }
                return true;
            }

            static void bfs(StringBuilder sb){
                boolean[] visited = new boolean[N+1];
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(V);
                visited[V] = true;

                while (!q.isEmpty()){
                    int temp = q.poll();
                    sb.append(temp).append(" ");
                    for (int l : adj.get(temp)) {
                        if(!visited[l]){
                            q.add(l);
                            visited[l] = true;
                        }
                    }
                }

            }
        }
