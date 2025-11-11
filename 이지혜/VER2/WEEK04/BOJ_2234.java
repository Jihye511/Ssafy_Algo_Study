import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, brokenMax, maxRoom;
    public static int[][] arr, visited;
    public static Map<Integer, Integer> map = new HashMap<>(); // 방번호 : 방사이즈

    public static int[] dirX = {0, -1, 0, 1};
    public static int[] dirY = {-1, 0, 1, 0};

    public static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 방번호 및 방 크기 체크(visited에 체크)
        bfs();
        // visited를 돌면서 다른 번호일때, 합구하기
        brokenBfs();

        System.out.println(map.size());
        System.out.println(maxRoom );
        System.out.println(brokenMax);

    }

    // 성 돌기
    public static void bfs() {

        q = new LinkedList<>();
        int roomNum = 0;
        int roomSize = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 미방문한곳이면 방문
                if (visited[i][j] == 0) {
                    // 방 번호 설정
                    visited[i][j] = ++roomNum;
                    // 방 크기
                    roomSize = 1;
                    q.offer(new int[]{i, j});

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();

                        int x = cur[0];
                        int y = cur[1];

                        for (int idx = 0; idx < 4; idx++) {
                            int nx = x + dirX[idx];
                            int ny = y + dirY[idx];

                            // 성 벗어난 경우
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                                continue;
                            }
                            // 벽이 없으면서 방문하지 않았으면
                            if ((arr[x][y] & (1 << idx)) == 0 && visited[nx][ny] == 0) {
                                visited[nx][ny] = visited[x][y];
                                q.offer(new int[]{nx, ny});
                                // 방 크기 증가
                                roomSize++;
                            }
                        }
                    }
                    // 방 저장
                    map.put(roomNum, roomSize);
                    // 최대방이면 변경
                    maxRoom = Math.max(maxRoom, roomSize);
                }

            }
        }
    }


    // 다른 방 만나면 체크
    public static void brokenBfs() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 현재방번호
                int roomNum = visited[i][j];


                for (int idx = 0; idx < 4; idx++) {
                    int nx = i + dirX[idx];
                    int ny = j + dirY[idx];

                    // 성 벗어난 경우
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                        continue;
                    }
                    // 현재방번호랑 다를 시
                    if (visited[nx][ny] != roomNum) {
                        // 현재방 + 다른방 최대값 비교
                        brokenMax = Math.max(brokenMax, map.get(roomNum) + map.get(visited[nx][ny]));
                    }
                }
            }
        }
    }
}
