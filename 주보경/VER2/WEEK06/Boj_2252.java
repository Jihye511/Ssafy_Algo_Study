import java.util.*;
import java.io.*;

public class Boj_2252_줄세우기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < N+1; i++) {
            adjList.add(new ArrayList<>());
        }

        //A B -> A < B
        //들어오는거  - 더 작음
        //나가는거  - 더 큼

        int[] indegree = new int[N+1];


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            adjList.get(a).add(b);
            indegree[b] += 1;
        }

        ArrayDeque<Integer> dq = new ArrayDeque<>();
    

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                dq.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        //정렬
        while (!dq.isEmpty()) {
            int curr = dq.poll();
            sb.append(curr).append(" ");
            for (int i = 0; i < adjList.get(curr).size(); i++) {
                indegree[adjList.get(curr).get(i)] -= 1;
                if (indegree[adjList.get(curr).get(i)] == 0) {
                    dq.add(adjList.get(curr).get(i));
                }
            }
        }

        System.out.println(sb);
    }
}
