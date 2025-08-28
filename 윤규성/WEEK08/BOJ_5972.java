import java.io.*;
import java.util.*;

public class Q5972 {
	
	public static class Node{
		int end, dest;
		
		public Node(int end, int dest) {
			this.end = end;
			this.dest = dest;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Node>[] way = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			way[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
		
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			
			way[a].add(new Node(b, c));
			way[b].add(new Node(a, c));
		}

		// 다익스트라
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dest, o2.dest));
		pq.add(new Node(0, 0));
		
		int[] ds = new int[N];
		Arrays.fill(ds, Integer.MAX_VALUE);
		
		A : while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(int i = 0; i < way[now.end].size(); i++) {
				Node next = way[now.end].get(i);
				
				if(ds[next.end] <= now.dest + next.dest) continue;
				
				ds[next.end] = now.dest + next.dest;
				pq.add(new Node(next.end, now.dest + next.dest));
			}
		}
		
		System.out.println(ds[N-1]);
		
	}

}
