import java.util.*;
import java.io.*;

public class Main {
	static int N, M, V;
	static int[][] graph;
	static boolean[] v;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken())-1;
		graph = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken())-1;
			int to = Integer.parseInt(st.nextToken())-1;
			graph[from][to] = graph[to][from] = 1;
		}
		 v = new boolean[N];

		dfs(V);
		System.out.println();
		v = new boolean[N];
		bfs(V);
	}
	private static void bfs(int c) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(c);
		v[c] = true;
		System.out.print(c + 1 + " ");
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i = 0; i < N; i++) {
				if(graph[cur][i]==1&&!v[i]) {
					v[i] = true;
					System.out.print(i + 1 + " ");
					q.add(i);
					
				}
			}
			
		}
		
	}
	private static void dfs(int c) {		
		v[c] = true;
		System.out.print(c+1+ " ");
		
		for (int i = 0; i < N; i++) {
			if(graph[c][i]==1&&!v[i]) {
				dfs(i);
			}
		}
		
	}

}
