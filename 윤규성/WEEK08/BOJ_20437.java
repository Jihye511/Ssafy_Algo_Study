import java.io.*;
import java.util.*;

public class BOJ_20437 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int test_case = Integer.parseInt(st.nextToken());

    for(int t = 0; t < test_case; t++){
      String str = br.readLine();
      char[] chs = str.toCharArray();
      int[] alpha = new int[26];
      for(char ch : chs){
        alpha[ch - 'a']  += 1;
      }
      int k = Integer.parseInt(br.readLine());

      int shortest = Integer.MAX_VALUE;
      int longest = Integer.MIN_VALUE;
      boolean flag = false;

      for(int i = 0; i < str.length(); i++){  // 시작점
        if(alpha[chs[i] - 'a'] < k) continue; // 시작점 문자 개수가 k개가 안되면 continue
        char start = chs[i];
        int cnt = 0;

        for(int j = i; j < str.length(); j++) {
          // 종료 지점이 같은 문자인지
          if (chs[j] == start)
            cnt++;
          else
            continue;
          // 정확히 k 개가 맞는지
          if (cnt != k)
            continue;

          shortest = Math.min(shortest, j - i + 1);
          longest = Math.max(longest, j - i + 1);
          flag = true;
          break;
        }
      }

      if(!flag) {
        sb.append("-1").append('\n');
      }else{
        sb.append(shortest + " " + longest).append('\n');
      }
    }

    System.out.print(sb);

  }
}
