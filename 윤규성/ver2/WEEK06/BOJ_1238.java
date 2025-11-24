import java.io.*;
import java.util.*;

public class Q1238 {

	public static class Node{
		int dest, dist;
		
		public Node(int dest, int dist) {
			this.dest = dest;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		
		ArrayList<Node>[] list = new ArrayList[N];
		for(int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int time = Integer.parseInt(st.nextToken());
			
			list[start].add(new Node(end, time));
		}
	
		int[] times = new int[N];
		Arrays.fill(times, Integer.MAX_VALUE);
		
		PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.dist, o2.dist));
		pq.add(new Node(X, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(int i = 0; i < list[now.dest].size(); i++) {
				Node next = list[now.dest].get(i);
				
				if(times[next.dest] > now.dist + next.dist) {
					times[next.dest] = now.dist + next.dist;
					pq.add(new Node(next.dest, now.dist + next.dist));
				}
				
			}
			
		}
				
		System.out.println(Arrays.toString(times));
		
		// 출발 -> X 
		int[] times_to_X = new int[N];
		
		for(int i = 0; i < N; i++) {
			int[] times_to_A = new int[N];
			Arrays.fill(times_to_A, Integer.MAX_VALUE);
			
			pq.add(new Node(i , 0));
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				
				for(int j = 0; j < list[now.dest].size(); j++) {
					Node next = list[now.dest].get(j);
					
					if(times_to_A[next.dest] > now.dist + next.dist) {
						times_to_A[next.dest] = now.dist + next.dist;
						pq.add(new Node(next.dest, now.dist + next.dist));
					}
					
				}
			}
			
			times_to_X[i] = times_to_A[X];
			
		}

		System.out.println(Arrays.toString(times_to_X));
		
		int ans = 0;
		for(int i = 0; i <N; i++) {
			if(i == X) continue;
			ans = Math.max(ans, times[i] + times_to_X[i]);
		}
		
		System.out.println(ans);
		
	}

}
