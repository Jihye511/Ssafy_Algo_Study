import java.io.*;
import java.util.*;

public class Q1260 {

	public static StringBuilder sb;
	public static int N, M, S;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		 S = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i = 0; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 0; i < N+1; i++) {
			Collections.sort(list[i], (o1, o2) -> Integer.compare(o1, o2));
		}
		
		boolean[] v = new boolean[N + 1];
		dfs(v, S, list);
		sb.append('\n');
		bfs(list);
		
		System.out.print(sb);
	}

	private static void dfs(boolean[] v, int now, ArrayList<Integer>[] list) {
		
		v[now] = true;
		sb.append(now).append(" ");
		
		for(int i = 0; i < list[now].size(); i++) {
			if(v[list[now].get(i)]) continue;
			dfs(v, list[now].get(i), list);
		}
		
	}

	private static void bfs(ArrayList<Integer>[] list) {

		boolean[] v = new boolean[N+1];
		ArrayDeque<Integer> queue = new ArrayDeque<>();

		v[S] = true;
		sb.append(S).append(" ");
		queue.add(S);

		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			
			for(int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i);
				
				if(v[next]) continue;
				
				v[next] = true;
				sb.append(next).append(" ");
				queue.add(next);
			}
		}
	}


}
