import java.util.*;
import java.io.*;

class Solution {
    static Map<Integer, List<Integer>> graph;
    static int n;
    public int[] solution(int[] nodes, int[][] edges) {
        int[] answer = new int[2]; // 0 : 홀짝트리 1: 역홀짝트리
        
        n = nodes.length;
        graph = new HashMap<>();
        for (int node : nodes) graph.putIfAbsent(node, new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            graph.putIfAbsent(a, new ArrayList<>());
            graph.putIfAbsent(b, new ArrayList<>());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Set<Integer> visited = new HashSet<>();
        for (int start : nodes) {
            if (!visited.add(start)) continue;

            int sameCount = 0;
            int diffCount = 0;

            ArrayDeque<Integer> q = new ArrayDeque<>();
            q.offer(start);

            while (!q.isEmpty()) {
                int cur = q.poll();

                int deg = graph.get(cur).size();

                if ( (cur & 1) == (deg & 1) ) sameCount++;
                else diffCount++;

                for (int nxt : graph.get(cur)) {
                    if (visited.add(nxt)) q.offer(nxt);
                }
            }
            if (sameCount == 1) answer[0]++;
            if (diffCount == 1) answer[1]++; 
        }
        return answer;
    }

}