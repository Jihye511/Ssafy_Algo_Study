import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20055 {

  public static int len, cnt, K, N;
  public static int[] A, R;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    len = 2 * N;
    A = new int[len];
    R = new int[len];

    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < len; i++){
      A[i] = Integer.parseInt(st.nextToken());
    }

    int phase = 1;
    while(cnt < K){
//      System.out.println(phase + " - - ");

      move(A);
      move(R);
      // 로봇 내려
      R[len / 2 - 1] = 0;
      R[len / 2] = 0;
//      System.out.println("움직임 + 로봇 내려");
//      System.out.println("A : " + Arrays.toString(A));
//      System.out.println("R : " + Arrays.toString(R));

      // 가장 먼저 들어간 로봇부터, 벨트 회전 방향으로 이동
      // 다음 칸 로봇 X && 다음 칸 내구도 > 0
      move_robot();
//      System.out.println("로봇 움직임");
//      System.out.println("A : " + Arrays.toString(A));
//      System.out.println("R : " + Arrays.toString(R));

      // 올리는 위치 내구도 > 0 이면 올려
      up();
//      System.out.println("로봇 올려");
//      System.out.println("A : " + Arrays.toString(A));
//      System.out.println("R : " + Arrays.toString(R));

      // 종료 조건
      if(stop()) {
        break;
      }
      phase ++;
    }

    System.out.println(phase);
  }

  private static boolean stop() {
    int c = 0;
    for(int i = 0; i < len; i++){
      if(A[i] <= 0) c ++;
    }

//    System.out.println("c : " + c);

    if( c >= K ) return true;
    else return false;
  }

  private static void up() {
    if(A[0] > 0) {
      R[0] = 1;
      A[0] -= 1;
    }
  }

  private static void move_robot() {
    for(int i = len - 2; i> 0; i--){
      if(R[i] == 1){
        if(R[i + 1] == 1) continue; // 다음 칸에 로봇 있으면 못가
        if(A[i + 1] <= 0) continue;

        R[i + 1] = 1;
        R[i] = 0;
        A[i + 1] -= 1;
      }
    }

  }

  public static void move(int[] prev) {
      int last = prev[prev.length - 1];

      for(int i = prev.length - 2; i >= 0 ; i--){
        prev[i+1] = prev[i];
      }

      prev[0] = last;
  }

}
