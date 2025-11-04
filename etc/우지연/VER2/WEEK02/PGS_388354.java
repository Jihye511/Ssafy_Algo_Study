import java.util.*;
class Solution {
 
    public int[] solution(int[] nodes, int[][] edges) {
         int maxVal = 0;
        boolean[] exists;
        for (int v : nodes) {
           maxVal = Math.max(maxVal, v); 
        }
            
        exists = new boolean[maxVal + 1];
        for (int v : nodes){
            exists[v] = true;
            
        } 
          List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= maxVal; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            int a = e[0], b = e[1];
            if (a <= maxVal && b <= maxVal && exists[a] && exists[b]) {
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
        }
          boolean[] visited = new boolean[maxVal + 1];
        
        int normal =0;
        int reverse=0;
        
        for(int start : nodes){
            if(visited[start])continue;
            
             List<Integer> comp = new ArrayList<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;

            while (!q.isEmpty()) {
                int cur = q.poll();
                comp.add(cur);
                for (int nxt : graph.get(cur)) {
                    if (!visited[nxt]) {
                        visited[nxt] = true;
                        q.add(nxt);
                    }
                }
            }

            int z = 0;
            int m = comp.size();

            for (int v : comp) {
                // 노드 번호 홀짝 판별
                int numParity;
                if (v % 2 == 0) {
                    numParity = 0; // 짝수
                } else {
                    numParity = 1; // 홀수
                }

                // 연결된 간선 수 홀짝 판별
                int degree = graph.get(v).size();
                int degParity;
                if (degree % 2 == 0) {
                    degParity = 0; // 짝수 개
                } else {
                    degParity = 1; // 홀수 개
                }

                // 두 홀짝 비교
                int s;
                if (numParity == degParity) {
                    s = 0; // 같음
                } else {
                    s = 1; // 다름
                }

                // s == 0 인 노드 수 세기
                if (s == 0) {
                    z++;
                }
            }

            if (z == 1) {
                normal++;      
            }
            if (z == m - 1) {
                reverse++;    
            }
        }

 
        return new int[]{normal, reverse};
    }
}
