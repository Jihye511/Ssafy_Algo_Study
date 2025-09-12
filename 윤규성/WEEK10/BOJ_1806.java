import java.io.*;
import java.util.*;

public class Q1806 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		 st = new StringTokenizer(br.readLine());
		int[] part_sum = new int[N];
		for(int i =0; i<N; i++) {
			if(i == 0) part_sum[i] = Integer.parseInt(st.nextToken());
			else part_sum[i] = part_sum[i-1] + Integer.parseInt(st.nextToken());
		}
		
		int min = Integer.MAX_VALUE;
		boolean tcd = false;
		int j = 0;
		
		//System.out.println(Arrays.toString(part_sum));
		A:for(int i =0; i<N; i++) {
			
			int diff;
			
			if(j > 0) diff = part_sum[j-1];
			else diff = 0;	
			int now_check = part_sum[i] - diff;
						
			while(now_check >= S) {
				tcd = true;
				min = Math.min(min, i-j+1);
				now_check = part_sum[i] - part_sum[j];
				j++;
				
				if(min == 1) break A;
			}			
		}
		
		if(tcd) System.out.println(min);
		else System.out.println("0");

	} 
}
