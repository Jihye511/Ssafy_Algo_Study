    import java.util.*;
    import java.io.*;

    public class Main {
        static int N, M;
        public static void main(String[] args) throws Exception{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            HashSet<String> hash_set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                hash_set.add(br.readLine());
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                for (String temp : br.readLine().split(",")) {
                    if (hash_set.contains(temp)){
                        hash_set.remove(temp);
                    }
                }
                sb.append(hash_set.size()).append("\n");
            }
            System.out.println(sb);
        }
    }
