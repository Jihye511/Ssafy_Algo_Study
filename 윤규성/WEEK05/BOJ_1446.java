import java.util.Arrays;
import java.util.Scanner;

public class Q1446 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int D = sc.nextInt();

		int[][] paths = new int[N+1][3];
		for(int i = 1; i<=N; i++) {
			paths[i][0] = sc.nextInt();
			paths[i][1] = sc.nextInt();
			paths[i][2] = sc.nextInt();
		}
		
		Arrays.sort(paths, (o1, o2) -> {
			if(o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
			else if(o1[1] != o2[1]) return Integer.compare(o1[1], o2[1]);
			else return Integer.compare(o1[2], o2[2]);
		});


		
		int[][] dp = new int[N+1][2];
		
		// dp[0][x] = 지나온 거리
		// dp[1][x] = 남은 거리
		dp[0][0] = 0;
		dp[0][1] = D;
		
		for(int i =1; i<N+1; i++) {
			dp[i][1] = D - paths[i][1];
			dp[i][0] = Integer.MAX_VALUE;
		}
		
		//System.out.println(Arrays.deepToString(dp));
		for(int i = 1; i<=N; i++) {
			if(paths[i][1] > D) continue;
			
			for(int j = 0; j<i; j++) {
				if(paths[j][1] > D) continue;
				if(paths[j][1] <= paths[i][0]) {
					dp[i][0] = Math.min(dp[i][0], dp[j][0] + paths[i][2] + (paths[i][0] - paths[j][1]));
				}
			}
		}
		
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i<N+1; i++) {
			ans = Math.min(ans, dp[i][0] + dp[i][1]);
		}
		
		//System.out.println(Arrays.deepToString(dp));
		System.out.println(ans);
		
	}
}
