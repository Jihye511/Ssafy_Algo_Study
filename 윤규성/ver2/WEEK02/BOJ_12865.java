import java.util.*;
import java.io.*;

public class Q12865 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] weight = new int[N];
		int[] value = new int[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[K+1][N+1];

		for(int i = 1; i< K + 1; i++) {
			for(int j = 1; j < N + 1; j++) {
				
				int rest = i - weight[j-1];
				if(rest >= 0) {
					dp[i][j] = value[j-1] + dp[rest][j-1];
				}
				
				dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
				
			}
		}
		
			
		System.out.println(dp[K][N]);
		
	}

}
