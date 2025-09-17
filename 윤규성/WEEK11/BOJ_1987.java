import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1987 {
	
	public static int max = 0, N, M;
	public static int[] dX = {0, 0, -1, 1};
	public static int[] dY = {1, -1, 0, 0};
	public static char[][] ch;
	public static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ch = new char[N][M]; 
		v = new boolean[26];
		
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			for(int j = 0; j < M; j++) {
				ch[i][j] = str.charAt(j);
			}
		}
		
		v[ch[0][0] - 'A'] = true;
		dfs(0, 0, 1);
		System.out.println(max);
		
	}

	private static void dfs(int i, int j, int depth) {
		if(depth > max) {
			max = depth;
		}
		
		for(int d = 0; d < 4; d++) {
			int nX = i + dX[d];
			int nY = j + dY[d];
			
			
			if(nX < 0 || nY < 0 || nX >= N || nY >= M) continue;
			if(v[(int) ch[nX][nY] - 'A' ]) continue;
			
			v[(int) ch[nX][nY] - 'A' ] = true;
			
			dfs(nX, nY, depth + 1);
			
			v[(int) ch[nX][nY] - 'A' ] = false;
			
		}
		
	}

}
