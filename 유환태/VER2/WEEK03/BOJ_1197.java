import java.util.*;
import java.io.*;

public class Main {
	static int V, E;
	static PriorityQueue<Node> q = new PriorityQueue<>();
	static int[] parent;
	static class Node implements Comparable<Node>{
		int a;
		int b;
		int c;
		
		Node(int a, int b, int c){
			this.a = a;
			this.b = b;
			this.c = c;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		V= Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for (int e = 0; e < E; e++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			q.offer(new Node(a,b,c));
		}
		
		
		parent = new int[V];
		
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < E; i++) {
			Node cur = q.poll();
			if(cnt==V-1) break;
			if(FindSet(cur.a)!=FindSet(cur.b)) {
				Union(cur.a,cur.b);
				
				sum += cur.c;
				cnt++;
			}
		}
		System.out.println(sum);
		
	}
	private static void Union(int a, int b) {
		int pa = FindSet(a);
		int pb = FindSet(b);
		
		if(pa==pb) {
			return ;
		}
		if(a<b) {
			parent[pb] = pa;
		}else {
			parent[pa] = pb;
		}
	}
	private static int FindSet(int a) {
		if(a==parent[a]) return a;
		return parent[a] = FindSet(parent[a]);
	}

}
