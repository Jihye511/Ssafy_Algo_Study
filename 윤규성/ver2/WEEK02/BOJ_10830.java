import java.io.*;
import java.util.*;

public class BOJ_10830 {

  public static int N;
  public static int[][] base;
  public static final int MOD = 1000;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    long B = Long.parseLong(st.nextToken());

    int[][] mat = new int[N][N];
    for(int i = 0; i < N ; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        mat[i][j] = Integer.parseInt(st.nextToken());
        mat[i][j] %= MOD;
      }
    }

    base = mat;
    int[][] ans = matrixPow(B);
    for(int i = 0; i < N; i++){
      for(int j = 0 ; j <N; j++){
        System.out.print(ans[i][j] + " ");
      }
      System.out.println();
    }

  }

  private static int[][] matrixPow(long b) {     // 몇 번 할건지
    if(b == 1) return base;

    int[][] tmp = matrixPow(b/2);             //
    int[][] tmpPow2 = matrixMulti(tmp, tmp);     //

    if(b % 2 == 0) {
      return tmpPow2;
    }else{
      return  matrixMulti(tmpPow2, matrixPow(1));
    }

  }

  private static int[][] matrixMulti(int[][] a, int[][] b) {    // 실제 계산
    int[][] arr = new int[N][N];
    for(int i = 0; i < N; i ++){
      for(int j = 0; j < N; j++){
        for(int x = 0; x < N; x++){
         arr[i][j] += a[i][x] * b[x][j];
        }

        arr[i][j] %= MOD;
      }
    }

    return arr;
  }


}
