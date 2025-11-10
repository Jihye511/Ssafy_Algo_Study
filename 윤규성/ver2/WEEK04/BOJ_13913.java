import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_13913 {

  static final int MAX = 100_000;
  static int[] dist;   // 각 위치까지의 최소 이동 횟수
  static int[] prev;   // 경로 복원용: 해당 위치에 오기 직전 위치

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    dist = new int[MAX + 1];
    prev = new int[MAX + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(prev, -1);

    // BFS
    ArrayDeque<Integer> q = new ArrayDeque<>();
    q.add(N);
    dist[N] = 0;

    while (!q.isEmpty()) {
      int now = q.poll();
      if (now == K) break; // 목표 도달 시 조기 종료

      // now - 1
      if (now >= 1 && dist[now - 1] == Integer.MAX_VALUE) {
        dist[now - 1] = dist[now] + 1;
        prev[now - 1] = now;
        q.add(now - 1);
      }
      // now + 1
      if (now < MAX && dist[now + 1] == Integer.MAX_VALUE) {
        dist[now + 1] = dist[now] + 1;
        prev[now + 1] = now;
        q.add(now + 1);
      }
      // now * 2
      if (now != 0 && now * 2 <= MAX && dist[now * 2] == Integer.MAX_VALUE) {
        dist[now * 2] = dist[now] + 1;
        prev[now * 2] = now;
        q.add(now * 2);
      }
    }

    // 출력: 1) 최소 이동 횟수
    System.out.println(dist[K]);

    // 2) 경로 복원: K부터 N까지 prev 타고 올라간 뒤 역순 출력
    ArrayDeque<Integer> stack = new ArrayDeque<>();
    for (int cur = K; cur != -1; cur = prev[cur]) {
      stack.push(cur);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) {
      sb.append(stack.pop());
      if (!stack.isEmpty()) sb.append(' ');
    }
    System.out.println(sb.toString());
  }
}
