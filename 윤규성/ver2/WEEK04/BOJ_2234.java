import java.io.*;
import java.util.*;

public class BOJ_2234 {

  public static class Node{
    int x, y;
    public Node(int x, int y) { this.x = x; this.y = y; }
  }

  public static int[] dX = {0, -1, 0, 1}; // 서, 북, 동, 남
  public static int[] dY = {-1, 0, 1, 0};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    ArrayDeque<Node> q = new ArrayDeque<>();
    int room_cnt = 0;
    int max_room = 0;
    boolean[][] v = new boolean[N][M];

    // 추가: 방 id와 각 방 크기 저장
    int[][] roomId = new int[N][M];
    ArrayList<Integer> sizes = new ArrayList<>();
    sizes.add(0); // id를 1부터 쓰기 위해 더미

    for(int i = 0; i < N ; i++) {
      for(int j = 0; j < M; j++) {

        if(v[i][j]) continue;
        room_cnt++;

        q.add(new Node(i, j));
        v[i][j] = true;
        roomId[i][j] = room_cnt;

        int now_room = 0;

        while(!q.isEmpty()) {
          Node now = q.poll();
          now_room++;

          for(int d = 0; d < 4; d ++) {
            int nX = now.x + dX[d];
            int nY = now.y + dY[d];

            if(nX < 0 || nX >= N || nY < 0 || nY >= M) continue;

            int dd = (int) Math.pow(2, d);       // 1,2,4,8
            if((map[now.x][now.y] & dd) != 0) continue; // 벽 있으면 못 감

            if(v[nX][nY]) continue;

            v[nX][nY] = true;
            roomId[nX][nY] = room_cnt;  // 추가: 같은 방 id 기록
            q.add(new Node(nX, nY));
          }
        }

        sizes.add(now_room);             // 추가: 방 크기 저장
        max_room = Math.max(max_room, now_room);
      }
    }

    // 추가: 벽 하나 부쉈을 때 최대 방 크기 계산
    int max_merge = 0;
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < M; y++) {
        for (int d = 0; d < 4; d++) {
          int dd = (int) Math.pow(2, d);
          if ((map[x][y] & dd) == 0) continue; // 벽 없으면 스킵 (부술 벽이 아님)

          int nx = x + dX[d];
          int ny = y + dY[d];
          if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;

          int id1 = roomId[x][y];
          int id2 = roomId[nx][ny];
          if (id1 == id2) continue; // 같은 방이면 합쳐도 변화 없음

          int merged = sizes.get(id1) + sizes.get(id2);
          if (merged > max_merge) max_merge = merged;
        }
      }
    }

    System.out.println(room_cnt);
    System.out.println(max_room);
    System.out.println(max_merge); // 하나의 벽 제거 시 최대 방 크기
  }
}
