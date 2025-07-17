import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    static class Node {
        int weight;
        int dir;
        int r;
        int c;

        public Node(int weight, int dir, int r, int c) {
            this.weight = weight;
            this.dir = dir;
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N= Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //NxM
        map = new int[N+1][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] next = new int[] {-1,0,1};

        Deque<Node> pq = new ArrayDeque<>();
        for (int i = 0; i < M; i++) {
            pq.add(new Node(map[0][i],-1,0,i));
        }

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            for (int i = 0; i < 3; i++) {
                if (i == n.dir) {
                    //연속 같은 방향
                    continue;
                }
                //끝 확인
                int nr = n.r + 1;
                int nc = n.c + next[i];

                if (nr == N) {
                    answer = Math.min(answer,n.weight);
                    continue;
                }

                if (inRange(nr,nc)) {
                    pq.add(new Node(n.weight + map[nr][nc], i, nr, nc));
                }
            }
        }
        System.out.println(answer);
    }

    static boolean inRange(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}
