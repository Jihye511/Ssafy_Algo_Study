import java.util.*;
import java.io.*;


public class BOJ_5430 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder ans_sb = new StringBuilder();

    int T = Integer.parseInt(st.nextToken());

    A : for(int tc = 0; tc < T; tc++){
      String cmd = br.readLine();
      int N = Integer.parseInt(br.readLine());
      String arr = br.readLine();
      StringBuilder sb = new StringBuilder();

      ArrayDeque<Integer> q = new ArrayDeque<>();
      boolean flag = false;

      StringBuilder sb_to_make_num = new StringBuilder();
      for(int i = 0; i < arr.length(); i++){
        if(arr.charAt(i) >= '0' && arr.charAt(i) <= '9') {
          sb_to_make_num.append(arr.charAt(i));
        }else if(sb_to_make_num.length() > 0){
          int num = Integer.parseInt(sb_to_make_num.toString());
          q.addLast(num);

          sb_to_make_num = new StringBuilder();
        }
      }

      for(int i = 0; i < cmd.length(); i++){
        if(cmd.charAt(i) == 'D'){
          if(q.isEmpty()) {
            ans_sb.append("error").append('\n');
            continue A;
          }

          if(!flag) {
            q.pollFirst();
          }else {
            q.pollLast();
          }

        }else if(cmd.charAt(i) == 'R'){
          if(!flag) flag = true;
          else flag = false;
        }
      }

      sb.append('[');
      while(!q.isEmpty()){
        if(!flag) {
          sb.append(q.pollFirst());
        }
        else {
          sb.append(q.pollLast());
        }

        if(!q.isEmpty()) sb.append(',');
      }
      sb.append(']');

      ans_sb.append(sb.toString()).append('\n');
    }

    System.out.print(ans_sb.toString());

  }

}
