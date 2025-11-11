import java.util.*;
import java.io.*;

public class Boj_2234_성곽 {
    static int N,M;
    static int[][] map, room;
    static int[] dr = {0,-1,0,1};
    static int[] dc = {-1,0,1,0};  //서 북 동 남
    static int maxSize;
    static ArrayList<Integer> sizes;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //서쪽에 벽이 있을 때는 1을, 북쪽에 벽이 있을 때는 2를, 동쪽에 벽이 있을 때는 4를, 남쪽에 벽이 있을 때는 8을 더한 값

        int idx = 1; //방 번호 쓸 인덱스
        room = new int[N][M];
        maxSize = 0;
        sizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (room[i][j] == 0) {
                    //bfs
                    room[i][j] = idx;
                    bfs(i,j,idx);
                    idx++;
                }
            }
        }
        // 벽 제거
        int best = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int a = room[i][j]; //룸 번호
                for (int d = 0; d < 4; d++) {
                    if ((map[i][j] & (1 << d)) == 0) continue; //벽 없음
                    int nr = i + dr[d];
                    int nc = j + dc[d];

                    if(!inRange(nr,nc)) continue;
                    int b = room[nr][nc];
                    if (a == b) continue;
                    best = Math.max(best, sizes.get(a-1) + sizes.get(b-1));

                }
            }
        }

        System.out.println(idx-1);
        System.out.println(maxSize);
        System.out.println(best);

    }

    static void bfs(int r, int c, int idx) {
        //서쪽 1 북쪽  1<<1 동쪽 1<<2 남 1<<3
        Deque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[] {r,c});
        int size = 1;
        while (!dq.isEmpty()) {
            int[] curr = dq.poll();
            for (int i = 0; i < 4; i++) {
                int nr = curr[0] + dr[i];
                int nc = curr[1] + dc[i];
                if (!inRange(nr,nc)) continue;
                if ((map[curr[0]][curr[1]] & (1 << i)) == 0) {
                    //벽 없음 이동
                    if (room[nr][nc] != 0) continue;
                    room[nr][nc] = idx;
                    size++;
                    dq.add(new int[] {nr,nc});
                }
            }
        }
        maxSize = Math.max(maxSize, size);
        sizes.add(size);
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < M;
    }
}
