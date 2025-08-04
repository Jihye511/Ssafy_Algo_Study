import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1138 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();

    int[] arr = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());

    for(int i = 0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    int[] ans = new int[N];
    for(int i = 0; i < N ; i++){
      int cnt = 0;

      for(int j = 0; j < N; j++){
        if(ans[j] == 0) cnt ++; // 선점되지 않은 자리

        if(cnt - 1 == arr[i]) {
          ans[j] = i + 1;
          break;
        }
      }
    }

    for(int i = 0; i < N; i++){
      sb.append(ans[i]).append(" ");
    }

    System.out.println(sb);

  }
}
