import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_20922 {

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

      while(end < N && can_go(arr[end], map)){
          map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
          max = Math.max(max, end - start);
          end ++;
      }

      map.put(arr[start], map.get(arr[start]) - 1);
    }

    System.out.println(max);

  }

  private static boolean can_go(int i, HashMap<Integer, Integer> map) {
    if(!map.containsKey(i)) return true;
    else if(map.get(i) + 1 <= K) return true;

    else return false;
  }
}
