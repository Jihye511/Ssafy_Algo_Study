import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class BOJ_15961 {

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = 0;

    int N = Integer.parseInt(st.nextToken());
    int d = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    int[] arr = new int[N];
    for(int i = 0; i< N; i++){
      arr[i] = Integer.parseInt(br.readLine());
    }

    HashMap<Integer, Integer> map = new HashMap<>();
    // 초기값 세팅
    for(int i = 0; i < k; i++){
      map.put(arr[i], map.getOrDefault(arr[i] ,  0) + 1);
      max = Math.max(map.size(), max);
    }
//    for(Entry<Integer, Integer> set : map.entrySet()){
//      System.out.println(set.getKey()+ " " + set.getValue());
//    }
//    System.out.println();

    // 돌아
    for(int i = 0; i < N; i++){
      if(map.get(arr[i]) > 1) map.put(arr[i], map.get(arr[i]) - 1);
      else map.remove(arr[i]);

      int j = i + k;
      map.put(arr[j % N], map.getOrDefault(arr[j % N], 0) + 1);
//
//      for(Entry<Integer, Integer> set : map.entrySet()){
//        System.out.println(set.getKey()+ " " + set.getValue());
//      }
//      System.out.println();

      map.put(c, map.getOrDefault(c, 0) + 1);
      max = Math.max(max, map.size());
    }

    System.out.println(max);

  }
}
