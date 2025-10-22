import java.io.*;
import java.util.*;

public class BOJ_15724 {

  public static void main(String[] args) throws IOException {
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] map = new int[N][M];
    for(int i = 0 ; i < N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    // 누적 합
    int[][] dp = new int[N][M];
    for(int i = 0; i < N; i++){
      for(int j = 0; j< M; j++){
        if(i == 0 && j== 0) {
          dp[0][0] = map[0][0];
        }else if(j == 0) {
          dp[i][j] = dp[i-1][j] + map[i][j];
        }else if(i == 0) {
          dp[i][j] = dp[i][j-1] + map[i][j];
        }else{
          dp[i][j] = dp[i-1][j] + dp[i][j-1] + map[i][j] - dp[i-1][j-1];
        }
      }
    }
//
//    for(int i = 0; i < N ; i++){
//      System.out.println(Arrays.toString(dp[i]));
//    }

    int T = Integer.parseInt(br.readLine());
    for(int tc = 0; tc < T; tc++){
      st = new StringTokenizer(br.readLine());

      int sX = Integer.parseInt(st.nextToken()) - 1;
      int sY = Integer.parseInt(st.nextToken()) - 1;

      int eX = Integer.parseInt(st.nextToken()) - 1;
      int eY = Integer.parseInt(st.nextToken()) - 1;

      long ans = -1;
      if(sX == 0 && sY == 0) ans = dp[eX][eY];
      else if(sX == 0) ans = dp[eX][eY] - dp[eX][sY-1];
      else if(sY == 0) ans = dp[eX][eY] - dp[sX-1][eY];
      else ans = ans = dp[eX][eY] + dp[sX-1][sY-1] - dp[sX-1][eY] - dp[eX][sY-1];

      sb.append(ans).append('\n');
    }

    System.out.print(sb.toString());
  }

}
