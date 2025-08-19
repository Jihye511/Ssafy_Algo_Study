import java.io.*;

public class BOJ_15989  {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int[] dp_three = new int[10001];
    int[] dp_two = new int[10001];

    dp_two[2] = 1;
    dp_two[3] = 1;
    dp_three[3] = 1;

    for(int i = 4; i < 10001; i++){
      dp_two[i] = dp_two[i-2] + 1;
      dp_three[i] = dp_three[i-3] + dp_two[i-3] + 1;
    }

    int N = Integer.parseInt(br.readLine());
    for(int i = 0; i < N; i++){
      int now = Integer.parseInt(br.readLine());
      sb.append(dp_three[now] + dp_two[now] + 1).append('\n');
    }

    System.out.print(sb);
  }

}
