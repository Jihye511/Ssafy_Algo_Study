import java.io.*;
import java.util.*;

public class Q16234 {

	public static int N, L, R;
	public static int[][] map;
	public static int[] dX = {-1, 0, 0, 1};
	public static int[] dY = {0, -1, 1, 0};
	public static class Node {
		int x, y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int day = 0;
		while( is_open() ) {
			open();
			day++;
		}
		
		System.out.println(day);
	}

	private static void open() {
		boolean[][] v = new boolean[N][N];
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		for(int i = 0; i <N; i++) {
			for(int j = 0; j < N; j++) {
				if(v[i][j]) continue;
				
				q.add(new Node(i, j));
				ArrayList<Node> list = new ArrayList<>();
				int sum = 0;
				
				while(!q.isEmpty()) {
					Node now = q.poll();
					int now_num = map[now.x][now.y];
					
					for(int d = 0; d < 4; d++) {
						int nX = now.x + dX[d];
						int nY = now.y + dY[d];
						
						if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
						if(v[nX][nY]) continue;
						
						int next_num = map[nX][nY];
						if(Math.abs(now_num - next_num) >= L && Math.abs(now_num - next_num) <= R) {
							v[nX][nY] = true;
							q.add(new Node(nX, nY));
							
							sum += map[nX][nY];
							list.add(new Node(nX, nY));
						}
						
					
					}
				}
			
				if(list.size() > 0) {
					int avg = sum / list.size();
					for(Node node : list) {
						map[node.x][node.y] = avg;
					}
				}
				
			}
		}
		
	}

	private static boolean is_open() {
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <N; j++) {
				int now = map[i][j];
				
				for(int d = 0; d < 4; d++) {
					int nX = i + dX[d];
					int nY = j + dY[d];
					
					if(nX < 0 || nX >= N || nY < 0 || nY >= N) continue;
					
					int next = map[nX][nY];
					
					if(Math.abs(now - next) >= L && Math.abs(now - next) <= R) return true;
				}
			}
		}
		
		return false;
	}

}
