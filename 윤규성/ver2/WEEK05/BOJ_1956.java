import java.io.*;
import java.util.*;

public class BOJ_1956 {

  public static int N, V;
  public static int[][] map;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    map = new int[N][N];
    for(int i = 0; i < N; i++){
      Arrays.fill(map[i], Integer.MAX_VALUE);
    }

    for(int i = 0; i < V; i++){
      st = new StringTokenizer(br.readLine());

      int s = Integer.parseInt(st.nextToken()) - 1;
      int e = Integer.parseInt(st.nextToken()) - 1;
      int d = Integer.parseInt(st.nextToken());

      map[s][e] = d;
    }

    for(int k = 0; k < N; k++) {
      for(int i= 0; i < N; i++){
        for(int j = 0; j < N; j++){

          if(map[i][k] == Integer.MAX_VALUE) continue;
          if(map[k][j] == Integer.MAX_VALUE) continue;

          map[i][j] = Math.min(map[i][j] , map[i][k] + map[k][j]);

        }
      }
    }

    for(int i = 0; i < N; i++){
      // System.out.println(Arrays.toString(map[i]));
    }

    int ans = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++) {
      ans = Math.min(ans, map[i][i]);
    }

    if(ans == Integer.MAX_VALUE) {
      System.out.println("-1");
    }
    else System.out.println(ans);

  }

}
