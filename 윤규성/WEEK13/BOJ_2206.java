import java.io.*;
import java.util.*;

public class Q2206 {
	
	public static class Node{
		int x, y, dist, is_passed;
		
		public Node(int x, int y, int dist, int is_passed) {
			this.x = x;
			this.y = y;
			this.dist = dist;
			this.is_passed = is_passed;
		}
	}
	
	public static int[] dX = {0, 0, -1, 1};
	public static int[] dY = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';	
			}
			
		}
		
		boolean [][][] v = new boolean[N][M][2];

		ArrayDeque<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 1, 0));
		int ans = -1;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			if(now.x == N-1 && now.y == M-1) {
				ans = now.dist;
				break;
			}
			
			for(int d = 0; d < 4; d++) {
				int nX = now.x + dX[d];
				int nY = now.y + dY[d];
				
				if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
				if(now.is_passed == 1 && map[nX][nY] == 1) continue;
				
				if(now.is_passed == 1)  {
					// 이미 부쉈던 경우
					if(v[nX][nY][1]) continue;
					v[nX][nY][1] = true;
					q.add(new Node(nX, nY, now.dist + 1, now.is_passed));
				}else {
					if(map[nX][nY] == 1) {	// 다음이 벽이면
						if(v[nX][nY][1]) continue;
						v[nX][nY][1] = true;
						q.add(new Node(nX, nY, now.dist + 1, 1));
					}else {	// 다음이 길이면
						if(v[nX][nY][0]) continue;
						v[nX][nY][0] = true;
						q.add(new Node(nX, nY, now.dist + 1, now.is_passed));
					}
					
				}

			}
		}
		
		System.out.println(ans);
		
	}
}
