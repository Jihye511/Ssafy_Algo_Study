package 신승용.VER2.WEEK02;

import java.util.*;

class PG_388354 {
    public int[] solution(int[] nodes, int[][] edges) {
        int n = nodes.length;

        Map<Integer, Integer> idxMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            idxMap.put(nodes[i], i);
        }

        ArrayList<Integer>[] graph = new ArrayList[n];

        int[] degree = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int aIdx = idxMap.get(e[0]);
            int bIdx = idxMap.get(e[1]);
            graph[aIdx].add(bIdx);
            graph[bIdx].add(aIdx);
            degree[aIdx]++;
            degree[bIdx]++;
        }

        int holCount = 0;
        int revCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> comp = dfs(i, graph, visited);
                int misHol = 0;
                int misRev = 0;

                for (int idx : comp) {
                    int num = nodes[idx];
                    if ((num % 2) != ((degree[idx] - 1) % 2)) misHol++;
                    if ((num % 2) == ((degree[idx] - 1) % 2)) misRev++;
                }

                if (misHol == 1) holCount++;
                if (misRev == 1) revCount++;
            }
        }

        return new int[]{holCount, revCount};
    }

    private List<Integer> dfs(int start, List<Integer>[] graph, boolean[] visited) {
        List<Integer> comp = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            comp.add(cur);
            for (int nxt : graph[cur]) {
                if (!visited[nxt]) {
                    visited[nxt] = true;
                    stack.push(nxt);
                }
            }
        }
        return comp;
    }
}

