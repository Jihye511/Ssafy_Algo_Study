import java.util.*;
import java.io.*;

public class Main {

    static class Node implements Comparable<Node> {
        int l, h;

        Node(int l, int h) {
            this.l = l;
            this.h = h;
        }

        @Override
        public int compareTo(Node o) {
            return this.l - o.l;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Node> nodes = new ArrayList<>();

        int maxH = 0;
        int maxL = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());

            nodes.add(new Node(L, H));
            if (H > maxH) {
                maxH = H;
                maxL = L;
            }
        }

        Collections.sort(nodes);

        int maxIdx = 0;
        for (int i = 0; i < N; i++) {
            if (nodes.get(i).h == maxH) {
                maxIdx = i;
                break;
            }
        }

        int result = 0;

        int currentMaxHeight = nodes.get(0).h;
        int currentPos = nodes.get(0).l;

        for (int i = 1; i <= maxIdx; i++) {
            result += (nodes.get(i).l - currentPos) * currentMaxHeight;

            currentPos = nodes.get(i).l;
            currentMaxHeight = Math.max(currentMaxHeight, nodes.get(i).h);
        }

        currentMaxHeight = nodes.get(N - 1).h;
        currentPos = nodes.get(N - 1).l;

        for (int i = N - 2; i >= maxIdx; i--) {
            result += (currentPos - nodes.get(i).l) * currentMaxHeight;

            currentPos = nodes.get(i).l;
            currentMaxHeight = Math.max(currentMaxHeight, nodes.get(i).h);
        }

        result += maxH;

        System.out.println(result);
    }
}
