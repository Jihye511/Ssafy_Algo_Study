import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ_1197 {

  public static class Node{
    int dest, dist;

    public Node(int dest, int dist) {
      this.dest = dest;
      this.dist = dist;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    ArrayList<Node>[] list = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      list[i] = new ArrayList<>();
    }

    for (int j = 0; j < M; j++) {
      int a = sc.nextInt()-1;
      int b = sc.nextInt()-1;
      int c = sc.nextInt();

      list[a].add(new Node(b, c));
      list[b].add(new Node(a, c));
    }

    PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2)-> Integer.compare(o1.dist, o2.dist));
    for(int i = 0; i<list[0].size(); i++) {
      pq.add(list[0].get(i));
    }

    boolean[] visited = new boolean[N];
    visited[0] = true;
    int cnt = 0;
    int sum = 0;

    while(cnt < N-1) {

      Node now = pq.poll();
      int next = now.dest;
      if(visited[next]) continue;

      visited[next] = true;
      cnt++;
      sum += now.dist;

      for(int i = 0; i<list[next].size(); i++) {
        pq.add(list[next].get(i));
      }
    }

    //System.out.println(cnt);
    System.out.println(sum);

  }
}
