import java.io.*;
import java.util.*;

public class Q2629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ws = Integer.parseInt(st.nextToken());
		int[] weights = new int[ws];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < ws; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			sum += weights[i];
		}
		
		int bs = Integer.parseInt(br.readLine());
		int[] beads = new int[bs];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < bs; i++) {
			beads[i] = Integer.parseInt(st.nextToken());
		}
		
		int limit = Math.min(sum, 15001);
		
		boolean[][] dp = new boolean[ws + 1][limit + 1];
		dp[0][0] = true;
		
		for(int i = 0; i < ws; i++) {
			for(int j = 0; j <= limit; j++) {
				if(!dp[i][j]) continue;
				
				dp[i + 1][j] = true;
				int nd1 = j + weights[i];
				if(nd1 <= limit) dp[i+1][nd1] = true;
				
				int nd2 = Math.abs(j - weights[i]);
				if(nd2 <= limit) dp[i+1][nd2] = true;
				
			}
		}
	
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < bs; i++) {
			int b = beads[i];
			if(b > limit) sb.append("N ");
			else { 
				if( dp[ws][b] ) sb.append("Y ");
				else sb.append("N ");				
			}
		}
		System.out.println(sb.toString());
	}

}
