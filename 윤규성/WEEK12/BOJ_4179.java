import java.io.*;
import java.util.*;

public class Q4179 {
	
	public static class Node {
		int x, y, t;
		
		public Node(int x, int y, int t) {
			this.x = x;
			this.y = y; 
			this.t = t; 
		}
	}
	
	public static int[] dX = {0, 0, -1, 1};
	public static int[] dY = {1, -1, 0, 0};
	public static int[][] map;
	public static int N, M;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 M = Integer.parseInt(st.nextToken());
		
		ArrayDeque<Node> fire = new ArrayDeque<>();
		ArrayDeque<Node> jihun = new ArrayDeque<>();
		
		// # ==> -1 벽
		// . ==> 0  길
		// J ==> 1  시작
		// F ==> 2	불
		// E ==> 3	탈출
		
		 map = new int[N][M];
		boolean[][] v = new boolean[N][M];
		
		for(int i = 0; i< N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				char ch = str.charAt(j);
				
				if(ch == '#') {
					map[i][j] = -1;
				}else if(ch == '.') {
					map[i][j] = 0;
				}else if(ch == 'J') {
					map[i][j] = 1;
					jihun.add(new Node(i, j, 0));
					v[i][j] = true;
				}else if(ch == 'F') {
					map[i][j] = 2;
					fire.add(new Node(i, j, -1));
				}
			}
		}
		
		int escape_time = -1;
		A : while(!jihun.isEmpty()) {
			
			int fire_size = fire.size();
			for(int i = 0; i < fire_size; i++) {
				Node fire_now = fire.poll();
				
				for(int d = 0; d < 4; d++) {
					int nX = fire_now.x + dX[d];
					int nY = fire_now.y + dY[d];
				
					if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
					if(map[nX][nY] == -1 || map[nX][nY] == 2) continue;
					
					map[nX][nY] = 2;
					fire.add(new Node(nX, nY, -1));
				}
			}
			
			int jihun_size = jihun.size();
			for(int i = 0; i < jihun_size; i++) {
				
				Node jihun_now = jihun.poll();
				if(isExit(jihun_now.x, jihun_now.y)) {
					escape_time = jihun_now.t + 1;
					break A; 
				}
				
				for(int d = 0 ; d < 4; d++) {
					int nX = jihun_now.x + dX[d];
					int nY = jihun_now.y + dY[d];
					
					if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
					if(map[nX][nY] == 2 || map[nX][nY] == -1) continue;
					else if(map[nX][nY] == 0 && !v[nX][nY]) {
						v[nX][nY] = true;
						jihun.add(new Node(nX, nY, jihun_now.t + 1));
					}else if(isExit(jihun_now.x, jihun_now.y)) {
						escape_time = jihun_now.t + 1;
						break A; 
					}
				}
			}
			
		}

		// 탈출 시
		if(escape_time == -1) System.out.println("IMPOSSIBLE");
		else System.out.println(escape_time);
	}

	public static boolean isExit(int nX, int nY) {
		if((nX == 0 || nY == 0 || nX == N-1 || nY == M-1 )) {
			return true;
		}
		
		return false;
	}
}
