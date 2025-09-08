import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {

  static int N;
  static int[] now, tar;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine().trim());
    now = new int[N];
    tar = new int[N];

    String n = br.readLine().trim();
    String t = br.readLine().trim();

    for (int i = 0; i < N; i++) now[i] = n.charAt(i) - '0';
    for (int i = 0; i < N; i++) tar[i] = t.charAt(i) - '0';

    int ans = Math.min(simulate(false), simulate(true));
    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
  }

  // pressFirst: 0번째 스위치를 시작 전에 누를지 여부
  private static int simulate(boolean pressFirst) {
    int[] arr = new int[N];
    System.arraycopy(now, 0, arr, 0, N);

    int cnt = 0;
    if (pressFirst) {
      toggle(arr, 0);
      cnt++;
    }

    // i번째에서 결정은 i-1을 맞추기 위해 이뤄진다
    for (int i = 1; i < N; i++) {
      if (arr[i - 1] != tar[i - 1]) {
        toggle(arr, i);
        cnt++;
      }
    }

    // 최종 일치 확인
    for (int i = 0; i < N; i++) {
      if (arr[i] != tar[i]) return Integer.MAX_VALUE; // 불가
    }
    return cnt;
  }

  // i 스위치 누르기: i-1, i, i+1 토글
  private static void toggle(int[] arr, int i) {
    if (i - 1 >= 0) arr[i - 1] ^= 1;
    arr[i] ^= 1;
    if (i + 1 < N) arr[i + 1] ^= 1;
  }
}
