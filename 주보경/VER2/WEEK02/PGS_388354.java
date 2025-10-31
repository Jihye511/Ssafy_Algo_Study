import java.util.*;

class Solution {
    static class Node {
        int[] p, r;
        Node(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) {
            while (p[x] != x) {
                p[x] = p[p[x]];
                x = p[x];
            }
            return x;
        }
        void union(int a, int b) {
            int ra = find(a), rb = find(b);
            if (ra == rb) return;
            if (r[ra] < r[rb]) {
                p[ra] = rb;
            } else if (r[ra] > r[rb]) {
                p[rb] = ra;
            } else {
                p[rb] = ra;
                r[ra]++;
            }
        }
    }

    public int[] solution(int[] nodes, int[][] edges) {
        int n = nodes.length;

        HashMap<Integer, Integer> idx = new HashMap<>(n * 2);
        for (int i = 0; i < n; i++) {
            idx.put(nodes[i], i);
        }

        Node node = new Node(n);
        int[] deg = new int[n];

        for (int[] e : edges) {
            int a = idx.get(e[0]);
            int b = idx.get(e[1]);
            deg[a]++; deg[b]++;
            node.union(a, b);
        }

        int[] compSize = new int[n];
        int[] compC0   = new int[n];
        boolean[] seen = new boolean[n];
        ArrayList<Integer> roots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int root = node.find(i);
            if (!seen[root]) { seen[root] = true; roots.add(root); }

            int D = deg[i] & 1;         
            int P = nodes[i] & 1;      
            int S = D ^ P;              

            compSize[root]++;
            if (S == 0) compC0[root]++;
        }

        int oddEvenTreeCount = 0;      
        int revOddEvenTreeCount = 0; 

        for (int r : roots) {
            int size = compSize[r];
            int c0 = compC0[r];
            if (c0 == 1) oddEvenTreeCount++;
            if ((size - c0) == 1) revOddEvenTreeCount++;
        }

        return new int[]{oddEvenTreeCount, revOddEvenTreeCount};
    }
}
