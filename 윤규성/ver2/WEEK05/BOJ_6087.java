import java.io.*;
import java.util.*;

public class Q6087 {

    static int W, H;
    static char[][] map;
    static final int INF = 1_000_000_000;

    // 상, 하, 좌, 우
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, dir, mirrors;

        public Node(int r, int c, int dir, int mirrors) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirrors = mirrors;
        }

        @Override
        public int compareTo(Node o) {
            return this.mirrors - o.mirrors;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken()); // 열(가로)
        H = Integer.parseInt(st.nextToken()); // 행(세로)

        map = new char[H][W];
        List<int[]> points = new ArrayList<>(); // C 두 개 위치 저장

        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    points.add(new int[]{i, j});
                }
            }
        }

        int[] start = points.get(0);
        int[] end = points.get(1);

        // dist[r][c][dir] = 해당 칸을 dir 방향으로 왔을 때 필요한 최소 거울 개수
        int[][][] dist = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(dist[i][j], INF);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작점에서의 초기 방향은 아무 방향이나 될 수 있으므로
        // 4방향 모두 비용 0으로 넣어두고 시작
        for (int d = 0; d < 4; d++) {
            dist[start[0]][start[1]][d] = 0;
            pq.offer(new Node(start[0], start[1], d, 0));
        }

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.mirrors > dist[cur.r][cur.c][cur.dir]) continue;

            for (int nd = 0; nd < 4; nd++) {
                int nr = cur.r + dr[nd];
                int nc = cur.c + dc[nd];

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == '*') continue; // 벽

                // 방향이 같으면 거울 추가 X, 다르면 거울 1개 추가
                int nMirrors = cur.mirrors + (cur.dir == nd ? 0 : 1);

                if (dist[nr][nc][nd] > nMirrors) {
                    dist[nr][nc][nd] = nMirrors;
                    pq.offer(new Node(nr, nc, nd, nMirrors));
                }
            }
        }

        int ans = INF;
        for (int d = 0; d < 4; d++) {
            ans = Math.min(ans, dist[end[0]][end[1]][d]);
        }

        System.out.println(ans);
    }
}
