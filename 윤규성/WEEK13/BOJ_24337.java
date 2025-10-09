import java.io.*;
import java.util.*;

public class BOJ_24337 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    Arrays.fill(arr, 1);

    if(a + b > N + 1) {
      System.out.println("-1");
      return;
    }

    if( a == 1 && b == 1) {
    }else if(a == 1) {
      arr[0] = b;

      int cnt = 1;
      for(int i = N-1; i > N-b; i--){
        arr[i] = cnt++;
      }
    }else if(b == 1){
      int cnt = a;
      for(int i = N-1; i >= N-a; i--){
        arr[i] = cnt--;
      }
    }else if( a > b ){
      int cnt = 1;

      for(int i = N-1; i > N-b; i--){
        arr[i] = cnt++;
      }

      cnt = a;
      for(int i = N-b; i > N-b-a; i--){
        arr[i] = cnt--;
      }

    }else if( a <= b ){
      int cnt = 1;

      for(int i = N-1; i >= N-b; i--) {
        arr[i] = cnt++;
      }

      cnt = a - 1;
      for(int i = N-b-1; i > N-b-a; i--){
        arr[i] = cnt--;
      }
    }

    for(int i = 0; i < N ; i++){
      System.out.print(arr[i] + " ");
    }

  }

}
