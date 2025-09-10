import java.util.*;
import java.io.*;

public class Boj_4485_녹색옷젤다 {
    static class Node implements Comparable<Node> {
        int r;
        int c;
        int cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 1;
        int[][] map;
        boolean[][] visited;
        while(true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) break;

            map = new int[N][N];
            visited = new boolean[N][N];
            StringTokenizer st;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<Node> dq = new PriorityQueue<>();
            dq.add(new Node(0,0,map[0][0]));

            int[] dr = {-1,1,0,0};
            int[] dc = {0,0,-1,1};

            int[][] dist = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dist[i], Integer.MAX_VALUE);
            }
            dist[0][0] = map[0][0];

            while (!dq.isEmpty()) {
                Node curr = dq.poll();
                if (curr.r == N-1 && curr.c == N-1) {
                    break;
                }
                if (visited[curr.r][curr.c]) continue;
                visited[curr.r][curr.c] = true;

                for (int d = 0; d < 4; d++) {
                    int nr = curr.r + dr[d];
                    int nc = curr.c + dc[d];

                    if (!inRange(nr,nc)) continue;
                    if (dist[nr][nc] > curr.cost + map[nr][nc]) {
                        dist[nr][nc] = curr.cost + map[nr][nc];
                        dq.add(new Node(nr,nc,dist[nr][nc]));
                    }
                }
            }

            System.out.printf("Problem %d: %d\n",T,dist[N-1][N-1]);
            T++;
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
 }
