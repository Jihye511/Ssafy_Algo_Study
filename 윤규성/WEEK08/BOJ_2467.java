import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2467_2 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ansL = 0;
		int ansR = 0;
		int min = Integer.MAX_VALUE;
		for(int now = 0; now < N-1 ; now++) {
			// now = idx 값임.
			int l = now + 1; 
			int r = N-1;
			int m;
			
			while(l < r){
				m = (l + r + 1) / 2;
				
				if(arr[now] + arr[m] < 0) {
					l = m;
				}else {
					r = m - 1;
				}
			}
			
			if(Math.abs(arr[now] + arr[l]) < min) {
				min = Math.abs(arr[now] + arr[l]);
				ansL = now;
				ansR = l;
			}
			
			if(l < N - 1) {
				int last = arr[l + 1];
				
				if(Math.abs(arr[now] + last) < min) {
					min = Math.abs(arr[ansL] + last);
					ansL = now;
					ansR = l + 1;
				}
			}
			
		}
		
		System.out.println(arr[ansL] + " " + arr[ansR]);
		
	}

}
