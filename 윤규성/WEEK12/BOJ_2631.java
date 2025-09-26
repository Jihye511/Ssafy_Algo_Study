import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2631 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for(int i = 0; i <N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
		
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			
			int max = 0;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) max = Math.max(max, dp[j]);
			}
			
			dp[i] = max + 1;
		}
		
		// System.out.println(Arrays.toString(dp));
		System.out.println(N - Arrays.stream(dp).max().getAsInt());
		
	}

}
