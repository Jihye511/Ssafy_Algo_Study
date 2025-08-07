import java.io.*;
import java.util.*;

public class Q20922 {

  public static int K;

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    int[] arr = new int[N];
    for(int i = 0; i<N; i++){
      arr[i] = Integer.parseInt(st.nextToken());
    }

    HashMap<Integer, Integer> map = new HashMap<>();

    int max = 1;
    int end = 0;
    for(int start = 0; start < N; start++){

      while(end < N && (!map.containsKey(arr[end]) || map.get(arr[end]) + 1 <= K)){
          map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
          max = Math.max(max, end - start);
          end ++;
      }

      map.put(arr[start], map.get(arr[start]) - 1);
    }

    System.out.println(max+1);

  }

}
