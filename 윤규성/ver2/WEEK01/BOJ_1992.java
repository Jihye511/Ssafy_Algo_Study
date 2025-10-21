import java.io.*;
import java.util.*;

public class BOJ_1992 {

  public static StringBuilder sb;
  public static int[][] map;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for(int i = 0; i < N ; i++) {
      String str = br.readLine();

      for(int  j = 0; j < N; j++){
        map[i][j] = str.charAt(j) - '0';
      }
    }

    sb = new StringBuilder();
    dfs(0, 0, N);

    System.out.println(sb.toString());
  }

  public static void dfs(int row, int col, int len) {
    if(len == 1) {
      sb.append(map[row][col]);
      return;
    }

    boolean flag = false;
    int start = map[row][col];
    A : for(int i = row; i < row + len ; i++){
      for(int j = col; j< col + len; j++){

        if(map[i][j] != start) {
            flag = true;
            break A;
        }

      }
    }

    if(flag) {
      sb.append('(');

      for(int i = 0; i < 2; i++) {
        for(int j = 0; j < 2; j++) {
          dfs(row + i * (len / 2) , col + j * (len / 2), len / 2);
        }
      }

      sb.append(')');
    }else{
      sb.append(start);
    }

  }
}
