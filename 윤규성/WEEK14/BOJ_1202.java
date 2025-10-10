import java.util.*;
import java.io.*;

public class Q1202 {

	public static class Node{
		int w, v;

		public Node(int w, int v) {
			this.w = w;
			this.v = v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		Node[] dia = new Node[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			dia[i] = new Node(a, b);
		}

		int[] bags = new int[K];
		for(int i = 0; i<K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(dia, ((o1, o2) -> Integer.compare(o1.w, o2.w)));
		Arrays.sort(bags);
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

		long total = 0;
		int idx = 0;
		
		for(int i = 0; i<K; i++) {
			int bag = bags[i];

			while(idx < N && dia[idx].w <= bag) {
				pq.add(dia[idx].v);
				idx++;
			}

			if(!pq.isEmpty()) {
				total += pq.poll();
			}
		}

		System.out.println(total);
	}
}
