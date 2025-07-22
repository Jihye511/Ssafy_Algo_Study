import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_20310 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringBuilder sb = new StringBuilder();

    int[] one_zero_cnt = new int[2];
    int N = str.length();

    for(int i = 0; i< str.length(); i++){
      int now = str.charAt(i) - '0';
      one_zero_cnt[now]++;
    }

    one_zero_cnt[0] /= 2;
    one_zero_cnt[1] /= 2;

    // tanos
    // 삭제 후 재정렬이 아니라 선택 삭제
    for(int i = 0; i< N; i++){
      if(str.charAt(i) == '0'){
        one_zero_cnt[0]--;
        if(one_zero_cnt[0] <= 0) sb.append('0');
      }else{
        one_zero_cnt[1]--;
        if(one_zero_cnt[1] > 0) sb.append('1');
      }
    }

    System.out.println(sb.toString());
  }
}
