import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q19637 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String[] names = new String[N];
		int[] nums = new int[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			names[i] = st.nextToken();
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i<M; i++) {
			int now = Integer.parseInt(br.readLine());
			
			int l = 0, r = N-1;
			int m = (l + r) / 2;
			
			while(l < r) {
				m = (l + r) / 2;
				
				if(nums[m] < now) {
					l = m + 1;
				}else {
					r = m;
				}
			}
			
			sb.append(names[r]).append('\n');
			
		}
		
		System.out.print(sb.toString());
		
	}
}
