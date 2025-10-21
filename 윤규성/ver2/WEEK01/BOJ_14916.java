import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_14916 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int M = Integer.parseInt(br.readLine());

    int ans = 0;
    if(M % 2 == 0) {  // 짝수
      int tmp = M / 5;

      if(tmp % 2 != 0) {
        tmp--;
      }

      ans += tmp;
      ans += (M - (tmp * 5)) / 2;
    }else {           // 홀수
      if (M < 5) {    // 1, 3
        System.out.println("-1");
        return;
      }else if(M % 5 == 0) {
        System.out.println(M / 5);
        return;
      }

      int tmp = M / 5;
      if(tmp % 2 == 0) {
        tmp--;
      }

      ans += tmp;
      ans += (M - (tmp * 5)) / 2;
    }

    System.out.println(ans);

  }
}
