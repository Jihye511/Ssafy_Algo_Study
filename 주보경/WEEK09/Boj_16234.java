import java.util.*;
import java.io.*;

public class Boj_16234_인구이동 {
    static int[][] map;
    static int N,L,R;
    static ArrayList<ArrayList<int[]>> groups;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        //지역 탐색 후 인구 이동 반복
        int day = 0;
        while (true) {
            groups = new ArrayList<>();
            find();
            if (groups.isEmpty()) {
                break;
            }
            move();
            day++;
        }
        System.out.println(day);
    }

    static void find() {
        boolean[][] v = new boolean[N][N];

        Deque<int[]> dq = new ArrayDeque<>();

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (v[i][j]) continue;
                dq.add(new int[] {i,j});
                v[i][j] = true;
                //인접하고 차이 조건 만족하는 그룹 저장
                ArrayList<int[]> group = new ArrayList<>();
                while (!dq.isEmpty()) {
                    int[] curr = dq.pollLast();
                    v[curr[0]][curr[1]] = true;
                    group.add(curr);

                    for (int d = 0; d < 4; d++) {
                        int nr = curr[0] + dr[d];
                        int nc = curr[1] + dc[d];
                        if (!inRange(nr,nc)) continue;
                        if (v[nr][nc]) continue;
                        int sub = Math.abs(map[curr[0]][curr[1]] - map[nr][nc]);
                        if (sub >= L && sub <= R) {
                            dq.add(new int[] {nr,nc});
                            v[nr][nc] = true;
                        }
                    }
                }

                if (!group.isEmpty()) {
                    if (group.size() > 1) groups.add(group);
                }

            }
        }
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    static void move() {
        for (ArrayList<int[]> group : groups) {
            int sum = 0;
            for (int[] c : group) {
                sum += map[c[0]][c[1]];
            }

            int changed = sum / group.size();
            for (int[] c : group) {
                map[c[0]][c[1]] = changed;
            }
        }
    }
}
