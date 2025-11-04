import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_5972 {
	public static class Node implements Comparable<Node> {
		int dest;
		int dist;

		public Node(int dest, int dist) {
			this.dest = dest;
			this.dist = dist;
		}

		public int compareTo(Node o) {
			return this.dist - o.dist;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Node>[] list = new List[N + 1];
		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}

		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] dist = new int[N + 1];
		boolean[] visit = new boolean[N + 1];

		pq.add(new Node(1, 0));
		Arrays.fill(dist, 50000001);
		dist[1] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visit[cur.dest])
				continue;
			visit[cur.dest] = true;

			for (Node next : list[cur.dest]) {
				if (dist[next.dest] > dist[cur.dest] + next.dist) {
					dist[next.dest] = dist[cur.dest] + next.dist;
					pq.offer(new Node(next.dest, dist[next.dest]));
				}
			}
		}
		System.out.println(dist[N]);
	}
}
