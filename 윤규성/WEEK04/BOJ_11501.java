import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11501 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int test_case = Integer.parseInt(br.readLine());
		
		for(int T = 0; T < test_case; T++) {
			int N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int[] stock = new int[N];
			for(int i = 0; i < N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			
			long profit = 0;
			int max = 0;
			for(int i = N-1; i >= 0; i--) {
				if(max < stock[i]) {
					max = stock[i];
					continue;
				}
				
				profit += max - stock[i];
			}
		
			sb.append(profit).append('\n');
		}
		
		System.out.print(sb);
	}

}
