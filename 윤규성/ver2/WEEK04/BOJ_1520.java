import java.io.*;
import java.util.*;

public class Q1520 {

	public static int[] dX = { 0, 0, -1, 1 };
	public static int[] dY = { -1, 1, 0, 0 };
	public static int[][] root, map;
	public static int N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		root = new int[N][M];
		for (int i = 0; i < root.length; i++) {
			Arrays.fill(root[i], -1);
		}
		
		System.out.println(dfs(0, 0));

	}

	private static int dfs(int i, int j) {
		
		if(i == N-1 && j == M-1) {
			return 1;
		}
		
		int now_way = 0;
		for(int d = 0; d < 4; d ++) {
			int nX = i + dX[d];
			int nY = j + dY[d];
			
			if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
			if(map[nX][nY] < map[i][j]) {
				if(root[nX][nY] == -1) now_way += dfs(nX, nY);
				else now_way += root[nX][nY];
			}
		}
		
		root[i][j] = now_way;
		return now_way;
	}


}
