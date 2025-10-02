import java.io.*;
import java.util.*;

public class BOJ_22866 {

  public static class Node{
    int v, i;

    public Node(int v, int i) {
      this.v = v;
      this.i = i;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N  = Integer.parseInt(br.readLine());
    int[] arr = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine());
    for(int i = 0; i <N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    // [][0] = NGE idx
    // [][1] = 개수
    int[] ans_num = new int[N];
    int[] nearest_num = new int[N];

    int[][] increasing = new int[N][2];

    // 뒤에 있는 나보다 큰 수를 세려야 함.
    Stack<Node> stack = new Stack<>();
    for(int i = N-1; i >= 0; i--) {
      int curNum = arr[i];

      while(!stack.isEmpty()){
        if(stack.peek().v > curNum) break;
        stack.pop();
      }

      if(stack.size() == 0) {
        increasing[i][0] = -1;
        increasing[i][1] = 0;
      }else{
        increasing[i][0] = stack.peek().i + 1;
        increasing[i][1] = stack.size();
      }

      stack.push(new Node(arr[i] , i));
    }

    int[][] decreasing = new int[N][2];
    stack = new Stack<>();
    for(int i = 0; i < N; i++) {
      int curNum = arr[i];

      while(!stack.isEmpty()){
        if(stack.peek().v > curNum) break;
        stack.pop();
      }

      if(stack.size() == 0) {
        decreasing[i][0] = -1;
        decreasing[i][1] = 0;
      }else{
        decreasing[i][0] = stack.peek().i + 1;
        decreasing[i][1] = stack.size();
      }

      stack.push(new Node(arr[i], i));
    }
    // 합계 추산
    for(int i = 0; i < N ; i++){
      ans_num[i] = increasing[i][1] + decreasing[i][1];
    }

    // nearest 결정
    for(int i = 0; i < N; i++){
      if(decreasing[i][0] == -1){
        nearest_num[i] = increasing[i][0];
      }else if(increasing[i][0] == -1){
        nearest_num[i] = decreasing[i][0];
      }else if(Math.abs(decreasing[i][0] - (i+1)) <= Math.abs(increasing[i][0] - (i+1))) {
        nearest_num[i] = decreasing[i][0];
      }else nearest_num[i] = increasing[i][0];
    }

    for(int i = 0; i < N; i++){
      if(ans_num[i] == 0) sb.append(ans_num[i]).append('\n');
      else{
        sb.append(ans_num[i] + " " + nearest_num[i]).append('\n');
      }
    }

    System.out.print(sb.toString());

  }
}
