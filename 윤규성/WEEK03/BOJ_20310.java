import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20310 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int[] one_zero_cnt = new int[2];
    int N = str.length();

    for(int i = 0; i< str.length(); i++){
      int now = str.charAt(i) - '0';
      one_zero_cnt[now]++;
    }

    // tanos
    // 삭제 후 재정렬이 아니라 선택 삭제
    boolean[] d = new boolean[N];
    int del_cnt = 0;

    // 1은 앞에서 부터 삭제
    for(int i = 0; i < N; i++){
      if(del_cnt == one_zero_cnt[1] / 2) break;

      if(str.charAt(i) == '1') {
        d[i] = true;
        del_cnt++;
      }
    }

    // 0은 뒤에서 부터 삭제
    del_cnt = 0;
    for(int i = N - 1 ; i > 0; i--){
      if(del_cnt == one_zero_cnt[0] / 2) break;

      if(str.charAt(i) == '0') {
        d[i] = true;
        del_cnt++;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++){
      if(!d[i]) sb.append(str.charAt(i));
    }

    System.out.println(sb.toString());
  }
}
