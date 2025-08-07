import java.io.*;
import java.util.*;

public class Q14940 {
	
	public static class Node{
		int x, y, d;
		
		public Node(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static int[] dX = {0, 0, -1, 1};
	public static int[] dY = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] dists = new int[N][M];
		int[] start = new int[2];

		for(int i = 0; i< N; i++) {
			Arrays.fill(dists[i], -1);
		}
		
		for(int i = 0; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					start[0] = i;
					start[1] = j;
				}else if(map[i][j] == 0) {
					dists[i][j] = 0;
				}
			}
		}
		
		ArrayDeque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(start[0], start[1], 0));
		dists[start[0]][start[1]] = 0;
		
		while(!queue.isEmpty()) {
			
			Node now = queue.poll();
			
			for(int d = 0; d < 4; d++) {
				int nX = now.x + dX[d];
				int nY = now.y + dY[d];
				
				if(nX < 0 || nX >= N || nY < 0|| nY >= M) continue;
				if(dists[nX][nY] != -1) continue;
				
				dists[nX][nY] = now.d + 1;
				queue.add(new Node(nX, nY, now.d + 1));
			}
		}
				
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M ; j++) {
				sb.append(dists[i][j] + " ");
			}
			sb.append('\n');
		}
		
		System.out.print(sb);
		
	}

}
