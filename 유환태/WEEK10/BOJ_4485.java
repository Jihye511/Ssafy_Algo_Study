import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int[][] map;
	static int[][] dist;
	static boolean[][] v;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static class Point implements Comparable<Point>{
		int r;
		int c;
		int loopy;
		Point(int r, int c ,int loopy){
			this.r = r;
			this.c = c;
			this.loopy = loopy;
		}
		
		@Override
		public int compareTo(Point o) {
			return Integer.compare(this.loopy, o.loopy);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int t = 1;
		
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N==0) break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			v = new boolean[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			PriorityQueue<Point > pq = new PriorityQueue<>();
			
			pq.add(new Point(0,0,map[0][0]));
			dist[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				Point cur = pq.poll();
				
				if(dist[cur.r][cur.c]<cur.loopy) continue;
				
				if(v[cur.r][cur.c]) continue;
				
				if(cur.r==N-1&&cur.c==N-1) {
					break;
				}
				v[cur.r][cur.c] = true;
				
				for (int i = 0; i < dr.length; i++) {
					int nr = cur.r +dr[i];
					int nc = cur.c +dc[i];
					
					if(nr>=0&&nc>=0&&nr<N&&nc<N) {
						int newW = cur.loopy + map[nr][nc];
						
						if(dist[nr][nc]>newW) {
							dist[nr][nc] = newW;
							pq.add(new Point(nr,nc,newW));
						}
					}
				}
			}
			System.out.printf("Problem %d: %d\n",t,dist[N-1][N-1]);
			t++;
		}
		
	}

}
