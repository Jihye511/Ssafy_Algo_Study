import java.util.*;
import java.io.*;

public class BOJ_2075 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
    StringTokenizer st;
    int now = 0;

    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0; j < N; j++){
        now = Integer.parseInt(st.nextToken());
        pq.add(now);
      }
    }

    for(int i = 0; i< N-1; i++){
      pq.poll();
    }

    System.out.println(pq.poll());
  }
}
