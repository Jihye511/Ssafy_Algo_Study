import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1931 {

  public static class Node{
    int start, end;

    public Node(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N  = Integer.parseInt(st.nextToken());

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
      if(o1.end != o2.end) return Integer.compare(o1.end, o2.end);
      else return Integer.compare(o1.start, o2.start);
    });

    for(int i = 0 ; i< N; i++){
      st = new StringTokenizer(br.readLine());
      int s = Integer.parseInt(st.nextToken());
      int e = Integer.parseInt(st.nextToken());

      pq.add(new Node(s, e));
    }

    int cnt = 0;
    int end = 0;
    while(!pq.isEmpty()) {
      Node now = pq.poll();

      if(now.start < end) continue;
      end = now.end;
      cnt++;
    }

    System.out.println(cnt);

  }

}
