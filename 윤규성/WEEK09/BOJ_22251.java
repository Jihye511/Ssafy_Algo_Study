import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q22251 {
	
	public static int N, K, P, Xnum, cnt;
	public static int[] selected;
	public static int[][] map;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 K = Integer.parseInt(st.nextToken());
		 P = Integer.parseInt(st.nextToken());
		String X = st.nextToken();
		char[] Xs = X.toCharArray();
		Xnum = Integer.parseInt(X);
		
		map = new int[10][10];
		int[][] nums = {
				{1, 1, 1, 0, 1, 1, 1},		// 0
				{0, 0, 1, 0, 0, 1, 0},		// 1
				{1, 0, 1, 1, 1, 0, 1},		// 2
				{1, 0, 1, 1, 0, 1, 1},		// 3
				{0, 1, 1, 1, 0, 1, 0},		// 4
				{1, 1, 0, 1, 0, 1, 1},		// 5
				{1, 1, 0, 1, 1, 1, 1},		// 6
				{1, 0, 1, 0, 0, 1, 0}, 		// 7
				{1, 1, 1, 1, 1, 1, 1},
				{1, 1, 1, 1, 0, 1, 1}		// 9
		};
		
		for(int i = 0; i < 10; i++) {
			for(int j =0; j <10; j++) {
				if(i == j) continue;
				if(map[i][j] != 0) continue;
				
				int cnt = 0;
				for(int c= 0 ; c <7; c++) {
					if(nums[i][c] != nums[j][c]) cnt++;
				}
				map[i][j] = cnt;
				map[j][i] = cnt;
			}
		}
		
		// for(int i = 0; i< 10; i++) { System.out.println(Arrays.toString(map[i])); }
	
		char[] now = new char[K];
		int len = Xs.length;
		for(int j = K-1; j > K-1-Xs.length; j--) {
			now[j] = Xs[len - 1];
			len --;
		}
		for(int i = 0; i <= K - 1 - Xs.length; i++) {
			now[i] = '0';
		}
		
		int[] nowD = new int[K];
		for(int i = 0; i < K; i++) {
			nowD[i] = now[i] - '0';
		}
		
		selected = new int[K];
		select(0, 0, nowD);
		
		System.out.println(cnt);
		
	}

	private static void select(int depth, int sum, int[] nowD) {
		if(sum > P) {		// 선택한 경우가 반전 가능 개수 P를 넘어감
			return;
		}
		
		if(depth >= K) {	// 다 고름
			int edge = 0;
			int ans = 0;
			
			for(int i = K-1; i >= 0; i--) {
				ans += selected[i] * Math.pow(10, edge);
				edge++;
			}
			
			if(ans <= N) {
				if(ans != Xnum && ans != 0) {
					
					System.out.println(ans);
					cnt++;	
				}
			}
			
			return;
		}
		
		
		// map[nowD[]][] 에서 하나 고르고 다음 단계로
		for(int i = 0; i < 10; i++) {
			selected[depth] = i;
			
			select(depth + 1, sum + map[nowD[depth]][i], nowD);
			
			selected[depth] = 0;
		}
		
	}

}
