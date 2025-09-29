import java.io.*;
import java.util.*;

public class Q14658 {
	
	public static int L;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[][] stars = new int[K][2];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			stars[i][0] = Integer.parseInt(st.nextToken());
			stars[i][1] = Integer.parseInt(st.nextToken());
		}

		int max = 0;
		// System.out.println(Math.min(max_N, N) + "  " + Math.min(max_M, M));
		
		for(int x = 0; x < K; x++) {
			for(int y = 0; y < K; y++) {
				int r = stars[x][0];
				int c = stars[y][1];

				int cnt = 0;
				
				for(int j = 0; j < K; j++) {
					if(is_in(r, c, stars[j][0], stars[j][1])) {
						cnt++;
					}
				}
				max = Math.max(max, cnt);
				
			}
		}
		
		System.out.println(K - max);
		
	}

	private static boolean is_in(int i, int j, int k, int l) {
		if((k >= i && k - i <= L) && (l >= j && l - j <= L)) return true;
		return false;
	}

}
