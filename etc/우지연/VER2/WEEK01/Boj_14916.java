import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp =new int[100001];
		int max = Integer.MAX_VALUE;
		
		dp[1]=max;
		dp[2]=1;
		dp[3]=max;
		dp[4]=2;
		dp[5]=1;
		
		for(int i=6;i<=N;i++) {
			dp[i]=Math.min(dp[i-2], dp[i-5])+1;
		}
		if(dp[N]==max) {
			System.out.println("-1");
		}
		else {
			System.out.println(dp[N]);
		}

	}

}
