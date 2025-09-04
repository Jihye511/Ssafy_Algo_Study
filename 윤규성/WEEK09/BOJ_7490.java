import java.io.*;
import java.util.*;

public class Q7490 {

  public static char[] op;
  public static StringBuilder sb;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());

    for(int test_case = 0; test_case < T; test_case++){
      int N = Integer.parseInt(br.readLine());

      char[] arr = new char[N*2 - 1];
      int now_n = 1;
      for(int i = 0; i < arr.length; i+=2){
        arr[i] = (char) (now_n + '0');
        now_n++;
      }

      op = new char[3];
      op[0] = ' ';
      op[1] = '+';
      op[2] = '-';

      dfs(0, arr,  N);
      sb.append('\n');
      // System.out.println(Arrays.toString(arr));

    }

    System.out.print(sb.toString());

  }

  private static void dfs(int depth, char[] arr, int N) {
    if(depth >= N - 1){

      // 계산 해보거라
      int result = res(arr);
      // System.out.println(Arrays.toString(arr) + " : " +result);

      if(result == 0) {
        for(int i = 0; i < arr.length; i++){
          sb.append(arr[i]);
        }
        sb.append('\n');
      }
      return;
    }

    for(int i = 0; i < 3; i++){
      arr[depth*2 + 1] = op[i];

      dfs(depth + 1, arr, N);
    }

  }

  private static int res(char[] arr) {
    int sum = 0;

    char last_op = '+';
    int idx = 0;

    StringBuilder now_build = new StringBuilder();

    while(idx < arr.length){
      if('0' <= arr[idx] && arr[idx] <= '9'){ // 숫자면 now 에 이어 붙혀

        now_build.append(arr[idx]);

      }else if(arr[idx] == '+'){ // + sum에
        if(last_op == '+'){
          int nowInt = Integer.parseInt(now_build.toString());
          now_build = new StringBuilder();
          sum += nowInt;
        }else{
          int nowInt = Integer.parseInt(now_build.toString());
          now_build = new StringBuilder();
          sum -= nowInt;
        }

        last_op = arr[idx];
      }else if(arr[idx] == '-'){
        if(last_op == '+'){
          int nowInt = Integer.parseInt(now_build.toString());
          now_build = new StringBuilder();
          sum += nowInt;
        }else{
          int nowInt = Integer.parseInt(now_build.toString());
          now_build = new StringBuilder();
          sum -= nowInt;
        }

        last_op = arr[idx];
      }

      // System.out.println(idx +" " + arr[idx] + " : " + sum + " / now: " + now_build.toString());
      idx++;
    }

    if(last_op == '+'){
      int nowInt = Integer.parseInt(now_build.toString());
      now_build = new StringBuilder();
      sum += nowInt;
    }else{
      int nowInt = Integer.parseInt(now_build.toString());
      now_build = new StringBuilder();
      sum -= nowInt;
    }

    return sum;
  }
}
