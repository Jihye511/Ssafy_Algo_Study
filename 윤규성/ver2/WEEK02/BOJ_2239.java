import java.io.*;
import java.util.*;

public class Q2239 {
	
	public static int[][] map;
	public static int N, zero_cnt;
	public static ArrayList<int[]> list;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = 9;
		map = new int[N][N];
		
		for(int i = 0; i < N ; i++) {
			String str = br.readLine();
			
			for(int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		zero_cnt = 0;
		list = new ArrayList<>();
		
		for(int i =0; i<N;i++) {
			for(int j =0; j< N; j++) {
				if(map[i][j] == 0) {
					zero_cnt++;
					int[] arr = {i, j};
					list.add(arr);
				}
			}
		}
				
		dfs(0);
	}

	private static void dfs(int depth) {		
		if(depth == zero_cnt) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			System.exit(0);
		}
		
		int x = list.get(depth)[0];
		int y = list.get(depth)[1];
		
		for(int k = 1; k <= N; k++) {
			if(row_check(x, k) && col_check(y, k) && box_check(x, y, k)) { 
				map[x][y] = k;
				dfs(depth + 1);
				map[x][y] = 0;
			}
		}
		
	}

	private static boolean box_check(int i, int j, int k) {
		int r = (i / 3) * 3;
		int c = (j / 3) * 3;
		
		// System.out.println(r +  " : " + c);
			
		for(int x = r; x < r + 3; x++) {
			for(int y = c; y < c + 3; y++) {
				if(map[x][y] == k) return false;
			}
		}
		
		return true;
	}

	private static boolean col_check(int j, int k) {
		for(int r = 0; r < 9; r++) {
			if(map[r][j] == k) return false;
		}
		
		return true;
	}

	private static boolean row_check(int i, int k) {
		
		for(int c = 0; c < 9; c++) {
			if(map[i][c] == k) return false;
		}
		
		return true;
	}

}
